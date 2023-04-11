package com.example.blog.demo.util;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageHelper;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;

/**
 * @author zhuqigang
 */
public class PageUtil<T> {

    /**
     * 页数
     */
    public static final String PAGE_NUM_KEY = "pageNum";

    /**
     * 默认页数
     */
    public static final Integer PAGE_NUM = 1;

    /**
     * 容量
     */
    public static final String PAGE_SIZE_KEY = "pageSize";

    /**
     * 默认容量
     */
    public static final Integer PAGE_SIZE = 20;

    /**
     * 初始化分页基础参数
     *
     * @param param 参数
     * @return 初始化后的参数
     */
    public static Map<String, Integer> initPageNumAndSize(Map<String, Object> param) {
        HashMap<String, Integer> pangNumAndPageSize = new HashMap<String, Integer>();
        Object pageNum = param.get(PAGE_NUM_KEY);
        Object pageSize = param.get(PAGE_SIZE_KEY);
        pangNumAndPageSize.put(PAGE_NUM_KEY, ObjectUtil.isEmpty(pageNum) ? PAGE_NUM : (Integer) pageNum);
        pangNumAndPageSize.put(PAGE_SIZE_KEY, ObjectUtil.isEmpty(pageSize) ? PAGE_SIZE : (Integer) pageSize);
        return pangNumAndPageSize;
    }

}
