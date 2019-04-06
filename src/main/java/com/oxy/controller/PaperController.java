package com.oxy.controller;

import javax.annotation.Resource;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oxy.service.PaperService;
import com.oxy.utils.JsonResult;
import com.oxy.vo.paper.AutoGeneratingVO;

@RestController
@RequestMapping("/paper")
@CrossOrigin
public class PaperController {
	@Resource
	private PaperService paperService;
	
	@RequestMapping(value="/autoGenerating",method = RequestMethod.POST,produces={
	"application/json;charset=utf-8"})
	public JsonResult add(@Validated @RequestBody AutoGeneratingVO vo){
		paperService.insert(vo);
		return new JsonResult(0,"添加成功");
	}
}
