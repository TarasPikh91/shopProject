package com.shop.service;

import java.util.List;

import com.shop.entity.Commodity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.multipart.MultipartFile;

public interface CommodityService {

	void save(Commodity commodity, List<Integer> discountId, int guaranteeId,
			  int producerId, List<Integer> categoriesId, MultipartFile multipartFile) throws Exception;

	List<Commodity> findAll();

	Commodity findOne(int id);

	void delete(int id);

	void update(Commodity commodity, List<Integer> discountId, int guaranteeId,
				int producerId, List<Integer> categoriesId, MultipartFile multipartFile);

	Page<Commodity> findAllPages(Pageable pageable);

	Page<Commodity> commodityWithCategoriesPages(Pageable pageable);

	Commodity commodityWithDiscounts(int id);
//
	Commodity commodityWithCategories(int id);


}
