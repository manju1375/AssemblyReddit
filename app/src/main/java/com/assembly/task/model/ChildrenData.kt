package com.assembly.task.model

import com.assembly.task.modelimport.MediaEmbed
import com.assemblytask.models.AllAwardings
import com.assemblytask.models.Gildings
import com.assemblytask.models.Preview
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ChildrenData (
    @SerializedName("approved_at_utc")
    val approvedAtUTC: JsonObject? = null,

    @SerializedName("subreddit")
    val subreddit: String? = null,

    @SerializedName("selftext")
    val selftext: String? = null,

    @SerializedName("author_fullname")
    @Expose
    val authorFullname: String? = null,

    @SerializedName("saved")
    val saved: Boolean? = null,

    @SerializedName("mod_reason_title")
    val modReasonTitle: JsonObject? = null,

    @SerializedName("gilded")
    val gilded: Long? = null,

    @SerializedName("clicked")
    val clicked: Boolean? = null,

    @SerializedName("title")
    @Expose
    val title: String? = null,

    @SerializedName("link_flair_richtext")
    val linkFlairRichtext: JsonArray? = JsonArray(),

    @SerializedName("subreddit_name_prefixed")
    val subredditNamePrefixed: String? = null,

    @SerializedName("hidden")
    val hidden: Boolean? = null,

    @SerializedName("pwls")
    val pwls: Long? = null,

    @SerializedName("link_flair_css_class")
    val linkFlairCSSClass: String? = null,

    @SerializedName("downs")
    val downs: Long? = null,

    @SerializedName("thumbnail_height")
    val thumbnailHeight: Long? = null,

    @SerializedName("top_awarded_type")
    val topAwardedType: JsonObject? = null,

    @SerializedName("hide_score")
    val hideScore: Boolean? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("quarantine")
    val quarantine: Boolean? = null,

    @SerializedName("link_flair_text_color")
    val linkFlairTextColor: String? = null,

    @SerializedName("upvote_ratio")
    val upvoteRatio: Double? = null,

    @SerializedName("author_flair_background_color")
    val authorFlairBackgroundColor: String? = null,

    @SerializedName("subreddit_type")
    val subredditType: String? = null,

    @SerializedName("ups")
    val ups: Long? = null,

    @SerializedName("total_awards_received")
    val totalAwardsReceived: Long? = null,

    @SerializedName("media_embed")
    val mediaEmbed: MediaEmbed? = MediaEmbed(),

    @SerializedName("thumbnail_width")
    val thumbnailWidth: Long? = null,

    @SerializedName("author_flair_template_id")
    val authorFlairTemplateID: JsonObject? = null,

    @SerializedName("is_original_content")
    val isOriginalContent: Boolean? = null,

    @SerializedName("user_reports")
    val userReports: JsonArray? = JsonArray(),

    @SerializedName("secure_media")
    val secureMedia: JsonObject? = null,

    @SerializedName("is_reddit_media_domain")
    val isRedditMediaDomain: Boolean? = null,

    @SerializedName("is_meta")
    val isMeta: Boolean? = null,

    @SerializedName("category")
    val category: JsonObject? = null,

    @SerializedName("secure_media_embed")
    val secureMediaEmbed: MediaEmbed= MediaEmbed(),

    @SerializedName("link_flair_text")
    val linkFlairText: String? = null,

    @SerializedName("can_mod_post")
    val canModPost: Boolean? = null,

    @SerializedName("score")
    val score: Long? = null,

    @SerializedName("approved_by")
    val approvedBy: JsonObject? = null,

    @SerializedName("is_created_from_ads_ui")
    val isCreatedFromAdsUI: Boolean? = null,

    @SerializedName("author_premium")
    val authorPremium: Boolean? = null,

    @SerializedName("thumbnail")
    @Expose
    val thumbnail: String? = null,

    @SerializedName("edited")
    val edited: Boolean? = null,

    @SerializedName("author_flair_css_class")
    val authorFlairCSSClass: String? = null,

    @SerializedName("author_flair_richtext")
    val authorFlairRichtext: JsonArray? = null,

    @SerializedName("gildings")
    val gildings: Gildings? = null,

    @SerializedName("post_hint")
    val postHint: String? = null,

    @SerializedName("content_categories")
    val contentCategories: List<String>? = null,

    @SerializedName("is_self")
    val isSelf: Boolean? = null,

    @SerializedName("mod_note")
    val modNote: JsonObject? = null,

    @SerializedName("created")
    val created: Long? = null,

    @SerializedName("link_flair_type")
    val linkFlairType: String? = null,

    @SerializedName("wls")
    val wls: Long? = null,

    @SerializedName("removed_by_category")
    val removedByCategory: JsonObject? = null,

    @SerializedName("banned_by")
    val bannedBy: JsonObject? = null,

    @SerializedName("author_flair_type")
    val authorFlairType: String? = null,

    @SerializedName("domain")
    val domain: String? = null,

    @SerializedName("allow_live_comments")
    val allowLiveComments: Boolean? = null,

    @SerializedName("selftext_html")
    val selftextHTML: JsonObject? = null,

    @SerializedName("likes")
    val likes: JsonObject? = null,

    @SerializedName("suggested_sort")
    val suggestedSort: JsonObject? = null,

    @SerializedName("banned_at_utc")
    val bannedAtUTC: JsonObject? = null,

    @SerializedName("url_overridden_by_dest")
    val urlOverriddenByDest: String? = null,

    @SerializedName("view_count")
    val viewCount: JsonObject? = null,

    @SerializedName("archived")
    val archived: Boolean? = null,

    @SerializedName("no_follow")
    val noFollow: Boolean? = null,

    @SerializedName("is_crosspostable")
    val isCrosspostable: Boolean? = null,

    @SerializedName("pinned")
    val pinned: Boolean? = null,

    @SerializedName("over_18")
    val over18: Boolean? = null,

    @SerializedName("preview")
    val preview: Preview? = Preview(),

    @SerializedName("all_awardings")
    val allAwardings: List<AllAwardings>? = ArrayList(),

    @SerializedName("awarders")
    val awarders: JsonArray? = JsonArray(),

    @SerializedName("media_only")
    val mediaOnly: Boolean? = null,

    @SerializedName("can_gild")
    val canGild: Boolean? = null,

    @SerializedName("spoiler")
    val spoiler: Boolean? = null,

    @SerializedName("locked")
    val locked: Boolean? = null,

    @SerializedName("author_flair_text")
    val authorFlairText: JsonObject? = null,

    @SerializedName("treatment_tags")
    val treatmentTags: JsonArray? = JsonArray(),

    @SerializedName("visited")
    val visited: Boolean? = null,

    @SerializedName("removed_by")
    val removedBy: JsonObject? = null,

    @SerializedName("num_reports")
    val numReports: JsonObject? = null,

    @SerializedName("distinguished")
    val distinguished: JsonObject? = null,

    @SerializedName("subreddit_id")
    val subredditID: String? = null,

    @SerializedName("author_is_blocked")
    val authorIsBlocked: Boolean? = null,

    @SerializedName("mod_reason_by")
    val modReasonBy: JsonObject? = null,

    @SerializedName("removal_reason")
    val removalReason: JsonObject? = null,

    @SerializedName("link_flair_background_color")
    val linkFlairBackgroundColor: String? = null,

    @SerializedName("id")
    @Expose
    val id: String? = null,

    @SerializedName("is_robot_indexable")
    val isRobotIndexable: Boolean? = null,

    @SerializedName("report_reasons")
    val reportReasons: JsonObject? = null,

    @SerializedName("author")
    @Expose
    val author: String? = null,

    @SerializedName("discussion_type")
    val discussionType: JsonObject? = null,

    @SerializedName("num_comments")
    val numComments: Long? = null,

    @SerializedName("send_replies")
    val sendReplies: Boolean? = null,

    @SerializedName("whitelist_status")
    val whitelistStatus: String? = null,

    @SerializedName("contest_mode")
    val contestMode: Boolean? = null,

    @SerializedName("mod_reports")
    val modReports: JsonArray? = JsonArray(),

    @SerializedName("author_patreon_flair")
    val authorPatreonFlair: Boolean? = null,

    @SerializedName("author_flair_text_color")
    val authorFlairTextColor: String? = null,

    @SerializedName("permalink")
    val permalink: String? = null,

    @SerializedName("parent_whitelist_status")
    val parentWhitelistStatus: String? = null,

    @SerializedName("stickied")
    val stickied: Boolean? = null,

    @SerializedName("url")
    @Expose
    val url: String? = null,

    @SerializedName("subreddit_subscribers")
    val subredditSubscribers: Long? = null,

    @SerializedName("created_utc")
    @Expose
    val createdUTC: Long? = null,

    @SerializedName("num_crossposts")
    val numCrossposts: Long? = null,

    @SerializedName("media")
    val media: JsonObject? = null,

    @SerializedName("is_video")
    val isVideo: Boolean? = null,

    @SerializedName("link_flair_template_id")
    val linkFlairTemplateID: String? = null
)