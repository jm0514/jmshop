package com.shop.jmshop.repository;

import com.shop.jmshop.dto.ItemSearchDto;
import com.shop.jmshop.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ItemRepositoryCustom {

    Page<Item> getAdminItemPage(ItemSearchDto itemSearchDto, Pageable pageable);
}
