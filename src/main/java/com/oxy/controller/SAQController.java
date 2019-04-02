package com.oxy.controller;

import javax.annotation.Resource;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oxy.service.SAQService;
import com.oxy.utils.JsonResult;
import com.oxy.vo.itemBank.AddSaqVO;
import com.oxy.vo.itemBank.DeleteSaqVO;
import com.oxy.vo.itemBank.PageSaqVO;
import com.oxy.vo.itemBank.UpdateSaqVO;

@RestController
@RequestMapping("/saq")
@CrossOrigin
public class SAQController {
	@Resource
	private SAQService saqService;
	
	@RequestMapping(value="/page",method = RequestMethod.POST,produces={
	"application/json;charset=utf-8"})
	public JsonResult pageResult(@Validated @RequestBody PageSaqVO vo){
		return new JsonResult(0,saqService.page(vo),"成功");
	}
	
	@RequestMapping(value="/",method = RequestMethod.POST,produces={
	"application/json;charset=utf-8"})
	public JsonResult add(@Validated @RequestBody AddSaqVO vo){
		saqService.insert(vo);
		return new JsonResult(0,"添加成功");
	}
	
	@RequestMapping(value="/",method = RequestMethod.PUT,produces={
	"application/json;charset=utf-8"})
	public JsonResult update(@Validated @RequestBody UpdateSaqVO vo){
		saqService.update(vo);
		return new JsonResult(0,"更新成功");
	}
	
	@RequestMapping(value="/",method = RequestMethod.DELETE,produces={
	"application/json;charset=utf-8"})
	public JsonResult delete(@RequestBody DeleteSaqVO vo){
		saqService.delete(vo.getSaqid());
		return new JsonResult(0,"删除成功");
	}
}
