package com.example.NewsService.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.NewsService.entity.News;
import com.example.NewsService.repository.NewsRepository;


@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsRepository newsRepository;

	@Override
	@Transactional
	public News addnews(News news) {
		// TODO Auto-generated method stub
		return newsRepository.save(news);
	}

	@Override
	public String deleteNews(int id) {
		// TODO Auto-generated method stub
		newsRepository.deleteById(id);
		return "xoa thanh cong id" + id;
	}

	@Override
	public News updateNews(News news) {
		News news2 = newsRepository.saveAndFlush(news);
		return news2;
	}

	@Override
	public News getNewsById(int id) {
		News news = newsRepository.findById(id).get();
		return news;
	}

	@Override
	public List<News> getListNews() {
		List<News> dsnews = newsRepository.findAll();
		return dsnews;
	}

	@Override
	public List<News> getNewsByTitle(String title) {
		return newsRepository.getNewsByTitle(title);
	}
}
