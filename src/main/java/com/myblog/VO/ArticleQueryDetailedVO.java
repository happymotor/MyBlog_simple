package com.myblog.VO;

import com.baomidou.mybatisplus.annotation.TableField;
import com.myblog.Common.RegexPatternsConstants;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleQueryDetailedVO {

    private Long articleId;

    private String title;

    private String content;

    private String htmlContent;

    private String summary;

    private Long categoryId;

    private String categoryName;

    private Long authorId;

    private String authorName;

    private List<String> tags;

    private Byte status;

    private Long viewCount;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
