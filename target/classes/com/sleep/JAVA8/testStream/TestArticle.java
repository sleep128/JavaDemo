package com.sleep.JAVA8.testStream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class TestArticle {

    /**
     * 在集合中查找包含"Java"标签的第一篇文章
     */
    @Test
    public void getFirstJavaArticle() {
        List<Article> articles = getArticles();
        Optional<Article> java = articles.stream().filter(article -> article.getTags().contains("Java")).findFirst();
        System.out.println(java);
    }

    /**
     * 获取所有tag包含"Java"的文章
     */
    @Test
    public void getAllJavaArticles() {
        List<Article> articles = getArticles();
        List<Article> javas = articles.stream().filter(article -> article.getTags().contains("Java")).collect(Collectors.toList());
        javas.stream().forEach(article -> System.out.println(article.getTitle()));
    }

    /**
     * 按照author，组装成map格式
     */
    @Test
    public void getMapByAuthor() {
        List<Article> articles = getArticles();
        Map<String, List<Article>> collect = articles.stream().collect(Collectors.groupingBy(Article::getAuthor));
        List<Article> articles1 = collect.get("author2");
        System.out.println(articles1);
    }

    @Test
    public void getAuthorStringList() {
        List<Article> articles = getArticles();
        List<String> collect = articles.stream().map(article -> article.getAuthor()).collect(Collectors.toList());
        collect.stream().forEach(s -> System.out.println(s));
    }

    @Test
    public void getAuthorMap() {
        List<Article> articles = getArticles();
        // 如果不作处理的话，当key重复时会报 duplicate key 异常，这里定义成后者覆盖前者
        Map<String, String> collect = articles.stream().collect(Collectors.toMap(Article::getTitle, Article::getAuthor,
                                                                                 (s, a) -> a));
        System.out.println(collect);

    }

    @Test
    public void getTagsMapMerge() {
        List<Article> articles = getArticlesNew();
        Map<String, List<String>> collect = articles.stream().collect(Collectors.toMap(Article::getTitle,
                                                                                       Article::getTags,
                                                                                       (t1, t2) -> mergeList(t1, t2)));
        System.out.println(collect);
    }

    private List mergeList(List<String> l1, List<String> l2) {
        l1.addAll(l2);
        return l1;
    }

    private List<Article> getArticles() {
        List<Article> articles = new ArrayList<>();

        List<String> a1Tags = Arrays.asList("Python", "C++", "Java", "C#");
        Article a1 = new Article("title1", "author1", a1Tags);
        articles.add(a1);

        List<String> a2Tags = Arrays.asList("Python2", "C++2", "Java2", "C#2");
        Article a2 = new Article("title1", "author2", a2Tags);
        articles.add(a2);

        List<String> a3Tags = Arrays.asList("Python", "C++", "C#");
        Article a3 = new Article("title3", "author3", a3Tags);
        articles.add(a3);

        return articles;
    }

    private List<Article> getArticlesNew() {
        List<Article> articles = new ArrayList<>();

        List<String> a1Tags = new ArrayList<>();
        a1Tags.addAll(Arrays.asList("Python", "C++", "Java", "C#"));
        Article a1 = new Article("title1", "author1", a1Tags);
        articles.add(a1);

        List<String> a2Tags = new ArrayList<>();
        a2Tags.addAll(Arrays.asList("Python2", "C++2", "Java2", "C#2"));
        Article a2 = new Article("title1", "author2", a2Tags);
        articles.add(a2);

        List<String> a3Tags = new ArrayList<>();
        a3Tags.addAll(Arrays.asList("Python", "C++", "C#"));
        Article a3 = new Article("title3", "author3", a3Tags);
        articles.add(a3);

        return articles;
    }

}
