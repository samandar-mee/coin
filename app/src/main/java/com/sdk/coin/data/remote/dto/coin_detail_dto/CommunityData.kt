package com.sdk.cryptoapp.data.data_source.dto.coin_detail_dto

data class CommunityData(
    val facebook_likes: Any,
    val reddit_accounts_active_48h: Int,
    val reddit_average_comments_48h: Double,
    val reddit_average_posts_48h: Double,
    val reddit_subscribers: Int,
    val telegram_channel_user_count: Any,
    val twitter_followers: Int
)