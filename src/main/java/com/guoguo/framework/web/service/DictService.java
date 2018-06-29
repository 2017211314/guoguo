package com.guoguo.framework.web.service;

import com.guoguo.project.system.dict.domain.DictData;
import com.guoguo.project.system.dict.service.IDictDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * GuoGuo首创 html调用 thymeleaf 实现字典读取
 * 
 * @author liuda
 */
@Component
public class DictService
{
    @Autowired
    private IDictDataService dictDataService;

    /**
     * 根据字典类型查询字典数据信息
     * 
     * @param dictType 字典类型
     * @return 参数键值
     */
    public List<DictData> selectDictData(String dictType)
    {
        return dictDataService.selectDictDataByType(dictType);
    }
}
