package com.myblog.Controller;

import com.myblog.Common.Result;
import com.myblog.Dto.ArticleAddAndUpdateDto;
import com.myblog.Dto.ArticlePageDto;
import com.myblog.Service.ArticleService;
import com.myblog.VO.*;
import com.myblog.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping
    public Result<ArticleAddVO> articleAdd(@RequestBody  @Validated ArticleAddAndUpdateDto articleAddAndUpdateDto){

        return articleService.articleAdd(articleAddAndUpdateDto);
    }

    @GetMapping("/list")
    public Result<PageVO<ArticlePageInfoVO>> articleQueryPages(@Validated ArticlePageDto articlePageDto){

        return articleService.articleQueryPages(articlePageDto);
    }

    @GetMapping("/{articleId}")
    public Result<ArticleQueryDetailedVO> ArticleQueryDetailed(@PathVariable Long articleId){

        return articleService.ArticleQueryDetailed(articleId);
    }

    @PutMapping("/{articleId}")
    public Result<ArticleUpdateVO> articleUpdate(@PathVariable Long articleId ,
                                                 @RequestBody  @Validated ArticleAddAndUpdateDto articleAddAndUpdateDto){
        return articleService.articleUpdate(articleId,articleAddAndUpdateDto);
    }

    @DeleteMapping("/{articleId}")
    public Result articleDelete(@PathVariable(name="articleId")List<Long> articleIds){

        return articleService.articleDelete(articleIds);
    }

}
