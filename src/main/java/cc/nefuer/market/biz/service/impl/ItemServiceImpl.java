package cc.nefuer.market.biz.service.impl;

import cc.nefuer.market.biz.service.ItemService;
import cc.nefuer.market.common.RestData;
import cc.nefuer.market.core.mapper.ItemMapper;
import cc.nefuer.market.core.mapper.UserMapper;
import cc.nefuer.market.core.model.Item;
import cc.nefuer.market.core.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jimi花
 * @dare 2018/7/28
 */
@Service
public class ItemServiceImpl implements ItemService {

    private final ItemMapper itemMapper;
    private final UserMapper userMapper;

    @Autowired
    public ItemServiceImpl(ItemMapper itemMapper,UserMapper userMapper) {
        this.userMapper = userMapper;
        this.itemMapper = itemMapper;
    }

    @Override
    public boolean postItem(Item item) {
        boolean rtv = false;
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        item.setCreateTime(localDateTime.format(format));
        item.setLastEditTime(localDateTime.format(format));
        rtv = 0 < itemMapper.insert(item);
        return rtv;
    }

    @Override
    public RestData getItem(Item item) {

        List<Map<String,Object>> rtv = new ArrayList<>();
        List<Item> data = itemMapper.selectItem(item);

        if(data.size() == 1) {
            User user = userMapper.selectByUserId(data.get(0).getPublishId());
            Map<String, Object> map = new HashMap<>(8);
            map.put("itemId",data.get(0).getItemId());
            map.put("name",data.get(0).getName());
            map.put("price",data.get(0).getPrice());
            map.put("content",data.get(0).getContent());
            map.put("sortId",data.get(0).getSortId());
            map.put("publishId",data.get(0).getPublishId());
            map.put("profileImg",user.getProfileImg());
            map.put("wechatName",user.getWechatName());
            map.put("views",data.get(0).getViews());
            map.put("status",data.get(0).getStatus());
            map.put("createTime",data.get(0).getCreateTime());
            return new RestData(map);
        } else {
            for(Item items : data) {
                if(items.getStatus() == 1) {
                    User user = userMapper.selectByUserId(items.getPublishId());
                    Map<String, Object> map = new HashMap<>(7);
                    map.put("itemId",items.getItemId());
                    map.put("name",items.getName());
                    map.put("price",items.getPrice());
                    map.put("sortId",items.getSortId());
                    map.put("content",items.getContent());
                    map.put("publishId",items.getPublishId());
                    map.put("profileImg",user.getProfileImg());
                    map.put("wechatName",user.getWechatName());
                    map.put("views",items.getViews());
                    map.put("createTime",items.getCreateTime());
                    rtv.add(map);
                }
            }

            return new RestData(rtv);
        }

    }
}
