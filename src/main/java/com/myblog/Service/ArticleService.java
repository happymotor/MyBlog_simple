package com.myblog.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myblog.Common.Result;
import com.myblog.Dto.ArticleAddAndUpdateDto;
import com.myblog.Dto.ArticlePageDto;
import com.myblog.VO.*;
import com.myblog.pojo.Article;

import java.util.List;

public interface ArticleService extends IService<Article> {
    Result<ArticleAddVO> articleAdd(ArticleAddAndUpdateDto articleAddAndUpdateDto);

    Result<PageVO<ArticlePageInfoVO>> articleQueryPages(ArticlePageDto articlePageDto);

    Result<ArticleQueryDetailedVO> ArticleQueryDetailed(Long articleId);

    Result<ArticleUpdateVO> articleUpdate(Long articleId, ArticleAddAndUpdateDto articleAddAndUpdateDto);

    Result articleDelete(List<Long> articleIds);
}
