package com.springboot.management.controller;

import com.github.pagehelper.PageInfo;
import com.springboot.management.common.utils.PageVO;
import com.springboot.management.service.ArticleService;
import com.springboot.management.vo.Article;
import com.springboot.management.vo.College;
import com.springboot.management.vo.Comment;
import com.springboot.management.vo.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @PostMapping(value = "/addArticle")
    public ResponseEntity<?> addArticle(@RequestBody Article article) {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        article.setCreateTime(timestamp);
        System.out.println("这是article"+article);
        articleService.addArticle(article);
        return ResponseEntity.ok("操作成功");
    }

    @PostMapping(value = "/findAllSort")
    public ResponseEntity<?> findAllSort(@RequestBody PageVO pageVO) {
        System.out.println("这是pagevo"+pageVO);
        PageInfo pageInfo = articleService.findAllSort(pageVO);
        System.out.println("这是pageinfo"+pageInfo);
        return ResponseEntity.ok(pageInfo);
    }

    //添加学院信息
    @PostMapping(value = "/addSort")
    public ResponseEntity<?> addSort(@RequestBody Sort sort) {
        articleService.addSort(sort);
        return ResponseEntity.ok("操作成功");
    }
    //修改学院信息
    @PostMapping(value = "/updateSort")
    public ResponseEntity<?> updateSort(@RequestBody Sort sort) {
        articleService.updateSort(sort);
        return ResponseEntity.ok("操作成功");
    }
    //单个学院的启用及禁用
    @PostMapping(value = "/banSort")
    public ResponseEntity<?> banSort(@RequestBody Sort sort) {
        articleService.banSort(sort);
        return ResponseEntity.ok("操作成功");
    }
    //批量禁用学院
    @GetMapping(value = "/banSortRows")
    public ResponseEntity<?> banSortRows(@RequestParam("ids") String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        articleService.banSortRows(list);
        System.out.println("这是list" + list);
        return ResponseEntity.ok("操作成功");
    }

    @PostMapping(value = "/findAllArticle")
    public ResponseEntity<?> findAllArticle(@RequestBody PageVO pageVO) {
        System.out.println("这是pagevo"+pageVO);
        PageInfo pageInfo = articleService.findAllArticle(pageVO);
        System.out.println("这是pageinfo"+pageInfo);
        return ResponseEntity.ok(pageInfo);
    }

    @GetMapping(value = "/getSort")
    public ResponseEntity<?> getSort() {
        List<Sort> list = articleService.getSort();
        return ResponseEntity.ok(list);
    }

    @PostMapping(value = "/banArticle")
    public ResponseEntity<?> banArticle(@RequestBody Article article) {
        articleService.banArticle(article);
        return ResponseEntity.ok("操作成功");
    }

    @GetMapping(value = "/banArticleRows")
    public ResponseEntity<?> banArticleRows(@RequestParam("ids") String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        articleService.banArticleRows(list);
        return ResponseEntity.ok("操作成功");
    }

    @GetMapping(value = "/getArticle")
    public ResponseEntity<?> getArticle(@RequestParam("id") int id) {
        Article article = articleService.getArticle(id);

        return ResponseEntity.ok(article);
    }
    @GetMapping(value = "/getComments")
    public ResponseEntity<?> getComments(@RequestParam("aid") int aid) {
        List<Comment> list = articleService.getComments(aid);
        return ResponseEntity.ok(list);
    }

    @PostMapping(value = "/addComments")
    public ResponseEntity<?> addComments(@RequestBody Comment comment) {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        comment.setTime(timestamp);
        articleService.addComments(comment);
        return ResponseEntity.ok("操作成功");
    }

    @PostMapping(value = "/addReply")
    public ResponseEntity<?> addReply(@RequestBody Comment comment) {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        comment.setTime(timestamp);
        articleService.addReply(comment);
        return ResponseEntity.ok("操作成功");
    }

}
