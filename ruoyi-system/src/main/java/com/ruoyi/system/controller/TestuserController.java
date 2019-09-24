package com.ruoyi.system.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Testuser;
import com.ruoyi.system.service.ITestuserService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 测试Controller
 * 
 * @author ruoyi
 * @date 2019-09-02
 */
@Controller
@RequestMapping("/system/testuser")
public class TestuserController extends BaseController
{
    private String prefix = "system/testuser";

    @Autowired
    private ITestuserService testuserService;

    @RequiresPermissions("system:testuser:view")
    @GetMapping()
    public String testuser()
    {
        return prefix + "/testuser";
    }

    /**
     * 查询测试列表
     */
    @RequiresPermissions("system:testuser:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Testuser testuser)
    {
        startPage();
        List<Testuser> list = testuserService.selectTestuserList(testuser);
        return getDataTable(list);
    }

    /**
     * 导出测试列表
     */
    @RequiresPermissions("system:testuser:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Testuser testuser)
    {
        List<Testuser> list = testuserService.selectTestuserList(testuser);
        ExcelUtil<Testuser> util = new ExcelUtil<Testuser>(Testuser.class);
        return util.exportExcel(list, "testuser");
    }
    /**
     * 新增测试
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存测试
     */
    @RequiresPermissions("system:testuser:add")
    @Log(title = "测试", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Testuser testuser)
    {
        return toAjax(testuserService.insertTestuser(testuser));
    }

    /**
     * 修改测试
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Testuser testuser = testuserService.selectTestuserById(id);
        mmap.put("testuser", testuser);
        return prefix + "/edit";
    }

    /**
     * 修改保存测试
     */
    @RequiresPermissions("system:testuser:edit")
    @Log(title = "测试", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Testuser testuser)
    {
        return toAjax(testuserService.updateTestuser(testuser));
    }

    /**
     * 删除测试
     */
    @RequiresPermissions("system:testuser:remove")
    @Log(title = "测试", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(testuserService.deleteTestuserByIds(ids));
    }
}
