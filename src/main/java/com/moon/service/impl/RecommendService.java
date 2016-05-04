package com.moon.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moon.common.util.PropUtils;
import com.moon.dao.impl.RecommendDao;
import com.moon.dao.impl.ShopMenuDao;
import com.moon.dao.impl.UserEventJedisDao;
import com.moon.entity.impl.RecommendMenu;
import com.moon.entity.impl.ShopMenu;
import com.moon.service.MoonService;

@Service("recommendService")
public class RecommendService implements MoonService {
	private static final long serialVersionUID = -2067198507259620547L;
	private static final Logger log = LoggerFactory.getLogger(RecommendService.class);
	private ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
	@Autowired
	private RecommendDao recommendDao;
	@Autowired
	private UserEventJedisDao userEventJedisDao;
	@Autowired
	private ShopMenuDao shopMenuDao;
	private InputStream input = null;
	private BufferedReader read;

	public List<RecommendMenu> query(long customerId) {
		try {
			return recommendDao.query(customerId);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception detail: {}", e.getMessage());
			throw new RuntimeException("It can not query recommend menus in recommendService.");
		}
	}
	public List<RecommendMenu> queryByRedis(long customerId){
		List<RecommendMenu> list=new ArrayList<RecommendMenu>();
		try{
			userEventJedisDao.getRecommendProduct(customerId).forEach((x,y)->{
				RecommendMenu menu=new RecommendMenu();
				menu.setShopMenuId(Long.parseLong(x));
				menu.setUserId(customerId);
				menu.setRating(Double.parseDouble(y));
				list.add(menu);
			});
		}catch(Exception e){
			e.printStackTrace();
			log.error("exception detail: ",e.getCause());
		}
		return list;

	}
	public void recommend() {
		cachedThreadPool.execute(new Runnable() {
			@Override
			public void run() {
				try {
					String[] sh = { "/bin/sh", "-c", PropUtils.getRecomendValue("sparkJar") };
					Process pro = Runtime.getRuntime().exec(sh);
					pro.waitFor();
					input = pro.getInputStream();
					read = new BufferedReader(new InputStreamReader(input));
					String result = null;
					while ((result = read.readLine()) != null) {
						log.info(result);
					}
				} catch (Exception e) {
					e.printStackTrace();
					log.error("exception detail: {}", e.getMessage());
					throw new RuntimeException("It can not query recommend form log in RecommendService");
				} finally {
					try {
						if (Objects.nonNull(input))
							input.close();
						if (Objects.nonNull(read))
							read.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}

	public void batchInsertRecommend() {
		FileInputStream finput = null;
		InputStreamReader fileReader = null;
		BufferedReader buffer = null;
		try {
			finput = new FileInputStream(new File("/home/lin/data/spark-data/recommend-menu.txt"));
			fileReader = new InputStreamReader(finput, "utf-8");
			buffer = new BufferedReader(fileReader);
			String line = null;
			String[] args = null;
			while ((line = buffer.readLine()) != null) {
				args = line.split("\t");
				Stream.of(args).forEach(System.out::println);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception detail: {}", e.getMessage());
			throw new RuntimeException("recommend-menu file read closed but found some exception");
		} finally {
			try {
				if (Objects.nonNull(buffer))
					buffer.close();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("exception detail: {}", e.getMessage());
				throw new RuntimeException("recommend-menu file buffer readerclosed but found some exception");
			}
			try {
				if (Objects.nonNull(fileReader))
					fileReader.close();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("exception detail: {}", e.getMessage());
				throw new RuntimeException("recommend-menu file reader closed but found some exception");
			}
			try {
				if (Objects.nonNull(finput))
					finput.close();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("exception detail: {}", e.getMessage());
				throw new RuntimeException("recommend-menu file inputstream closed but found some exception");
			}
		}
	}
}
