package main.controller;

import main.api.response.*;
import main.service.CaptchaService;
import main.service.PostService;
import main.service.TagService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/api")
public class ApiGetController {

    private final PostService postService;
    private final TagService tagService;
    private final CaptchaService captchaService;

    public ApiGetController(PostService postService, TagService tagService, CaptchaService captchaService) {
        this.postService = postService;
        this.tagService = tagService;
        this.captchaService = captchaService;
    }

    @GetMapping("/post")
    public PostResponse posts(@RequestParam(defaultValue = "recent") String mode
            , @RequestParam(defaultValue = "0") int offset
            , @RequestParam(defaultValue = "5") int limit) {
        return postService.getPosts(mode, offset, limit);
    }

    @GetMapping("/tag")
    public TagResponse tags(@RequestParam(defaultValue = "empty") String query) {
        return tagService.getTags(query);
    }

    @GetMapping("/post/search")
    public PostResponse postSearch(@RequestParam(defaultValue = "0") int offset
            , @RequestParam(defaultValue = "5") int limit, @RequestParam String query) {
        return postService.findPostByText(offset, limit, query);
    }

    @GetMapping("/calendar")
    public PostByYearResponse calendarInfo(@RequestParam(defaultValue = "2021") int year) {
        return postService.getPostCalendarInfo(year);
    }

    @GetMapping("/post/byDate")
    public PostResponse postByDate(@RequestParam(defaultValue = "0") int offset
            , @RequestParam(defaultValue = "5") int limit
            , @RequestParam(defaultValue = "2021-08-03") String date) {
        return postService.findPostByDate(offset, limit, date);
    }

    @GetMapping("/post/byTag")
    public PostResponse postByTag(@RequestParam(defaultValue = "0") int offset
            , @RequestParam(defaultValue = "5") int limit
            , @RequestParam(defaultValue = "news") String tag) {
        return postService.findPostByTag(offset, limit, tag);
    }

    @GetMapping("/post/{id}")
    public ResponseEntity postByID(@PathVariable int id) {
        return postService.getPostById(id);
    }

    @GetMapping("/auth/captcha")
    public CaptchaResponse getCaptcha() throws NoSuchAlgorithmException {
        return captchaService.getCaptchaInfo();
    }

    @GetMapping("/post/moderation")
    @PreAuthorize("hasAuthority('user:moderate')")
    public PostResponse getPostsForModeration(@RequestParam(defaultValue = "0") int offset
            , @RequestParam(defaultValue = "5") int limit
            , @RequestParam String status) {
        return postService.getPostsForModeration(offset, limit, status);
    }

    @GetMapping("post/my")
    @PreAuthorize("hasAuthority('user:write')")
    public PostResponse getMyPosts(@RequestParam(defaultValue = "0") int offset
            , @RequestParam(defaultValue = "5") int limit
            , @RequestParam String status) {
        return postService.findPostsByUserId(offset, limit, status);
    }

    @GetMapping("statistics/my")
    @PreAuthorize("hasAuthority('user:write')")
    public PostStatisticsResponse getMyStatistics() {
        return postService.getMyStatistics();
    }

    @GetMapping("statistics/all")
    public ResponseEntity<PostStatisticsResponse> getAllStatistics() {
        return postService.getAllStatistics();
    }
}
