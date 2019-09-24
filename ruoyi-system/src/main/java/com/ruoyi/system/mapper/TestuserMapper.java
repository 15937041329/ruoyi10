package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Testuser;
import java.util.List;

/**
 * 测试Mapper接口
 * 
 * @author ruoyi
 * @date 2019-09-02
 */
public interface TestuserMapper 
{
    /**
     * 查询测试
     * 
     * @param id 测试ID
     * @return 测试
     */
    public Testuser selectTestuserById(Long id);

    /**
     * 查询测试列表
     * 
     * @param testuser 测试
     * @return 测试集合
     */
    public List<Testuser> selectTestuserList(Testuser testuser);

    /**
     * 新增测试
     * 
     * @param testuser 测试
     * @return 结果
     */
    public int insertTestuser(Testuser testuser);

    /**
     * 修改测试
     * 
     * @param testuser 测试
     * @return 结果
     */
    public int updateTestuser(Testuser testuser);

    /**
     * 删除测试
     * 
     * @param id 测试ID
     * @return 结果
     */
    public int deleteTestuserById(Long id);

    /**
     * 批量删除测试
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTestuserByIds(String[] ids);
}
