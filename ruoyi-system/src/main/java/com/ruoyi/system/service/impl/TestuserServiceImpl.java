package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TestuserMapper;
import com.ruoyi.system.domain.Testuser;
import com.ruoyi.system.service.ITestuserService;
import com.ruoyi.common.core.text.Convert;

/**
 * 测试Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-09-02
 */
@Service
public class TestuserServiceImpl implements ITestuserService 
{
    @Autowired
    private TestuserMapper testuserMapper;

    /**
     * 查询测试
     * 
     * @param id 测试ID
     * @return 测试
     */
    @Override
    public Testuser selectTestuserById(Long id)
    {
        return testuserMapper.selectTestuserById(id);
    }

    /**
     * 查询测试列表
     * 
     * @param testuser 测试
     * @return 测试
     */
    @Override
    public List<Testuser> selectTestuserList(Testuser testuser)
    {
        return testuserMapper.selectTestuserList(testuser);
    }

    /**
     * 新增测试
     * 
     * @param testuser 测试
     * @return 结果
     */
    @Override
    public int insertTestuser(Testuser testuser)
    {
        return testuserMapper.insertTestuser(testuser);
    }

    /**
     * 修改测试
     * 
     * @param testuser 测试
     * @return 结果
     */
    @Override
    public int updateTestuser(Testuser testuser)
    {
        return testuserMapper.updateTestuser(testuser);
    }

    /**
     * 删除测试对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTestuserByIds(String ids)
    {
        return testuserMapper.deleteTestuserByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除测试信息
     * 
     * @param id 测试ID
     * @return 结果
     */
    public int deleteTestuserById(Long id)
    {
        return testuserMapper.deleteTestuserById(id);
    }
}
