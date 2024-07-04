package com.example.shop.Item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// 보통 서버에서 데이터를 보내주기 전에 이것저것 실행하는 거 -> 비즈니스 로직
@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public void saveItem(String title, Integer price) {
        Item item = new Item();
        item.setTitle(title);
        item.setPrice(price);
        System.out.println(item);
        itemRepository.save(item);
    }
}
