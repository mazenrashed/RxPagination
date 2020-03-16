package com.mazenrashed.rxpagination.data.model


import com.google.gson.annotations.SerializedName

data class GithubRepository(
    @SerializedName("archive_url")
    var archiveUrl: String,
    @SerializedName("archived")
    var archived: Boolean,
    @SerializedName("assignees_url")
    var assigneesUrl: String,
    @SerializedName("blobs_url")
    var blobsUrl: String,
    @SerializedName("branches_url")
    var branchesUrl: String,
    @SerializedName("clone_url")
    var cloneUrl: String,
    @SerializedName("collaborators_url")
    var collaboratorsUrl: String,
    @SerializedName("comments_url")
    var commentsUrl: String,
    @SerializedName("commits_url")
    var commitsUrl: String,
    @SerializedName("compare_url")
    var compareUrl: String,
    @SerializedName("contents_url")
    var contentsUrl: String,
    @SerializedName("contributors_url")
    var contributorsUrl: String,
    @SerializedName("created_at")
    var createdAt: String,
    @SerializedName("default_branch")
    var defaultBranch: String,
    @SerializedName("deployments_url")
    var deploymentsUrl: String,
    @SerializedName("description")
    var description: String,
    @SerializedName("disabled")
    var disabled: Boolean,
    @SerializedName("downloads_url")
    var downloadsUrl: String,
    @SerializedName("events_url")
    var eventsUrl: String,
    @SerializedName("fork")
    var fork: Boolean,
    @SerializedName("forks")
    var forks: Int,
    @SerializedName("forks_count")
    var forksCount: Int,
    @SerializedName("forks_url")
    var forksUrl: String,
    @SerializedName("full_name")
    var fullName: String,
    @SerializedName("git_commits_url")
    var gitCommitsUrl: String,
    @SerializedName("git_refs_url")
    var gitRefsUrl: String,
    @SerializedName("git_tags_url")
    var gitTagsUrl: String,
    @SerializedName("git_url")
    var gitUrl: String,
    @SerializedName("has_downloads")
    var hasDownloads: Boolean,
    @SerializedName("has_issues")
    var hasIssues: Boolean,
    @SerializedName("has_pages")
    var hasPages: Boolean,
    @SerializedName("has_projects")
    var hasProjects: Boolean,
    @SerializedName("has_wiki")
    var hasWiki: Boolean,
    @SerializedName("homepage")
    var homepage: Any,
    @SerializedName("hooks_url")
    var hooksUrl: String,
    @SerializedName("html_url")
    var htmlUrl: String,
    @SerializedName("id")
    var id: Int,
    @SerializedName("issue_comment_url")
    var issueCommentUrl: String,
    @SerializedName("issue_events_url")
    var issueEventsUrl: String,
    @SerializedName("issues_url")
    var issuesUrl: String,
    @SerializedName("keys_url")
    var keysUrl: String,
    @SerializedName("labels_url")
    var labelsUrl: String,
    @SerializedName("language")
    var language: String,
    @SerializedName("languages_url")
    var languagesUrl: String,
    @SerializedName("license")
    var license: License,
    @SerializedName("merges_url")
    var mergesUrl: String,
    @SerializedName("milestones_url")
    var milestonesUrl: String,
    @SerializedName("mirror_url")
    var mirrorUrl: Any,
    @SerializedName("name")
    var name: String,
    @SerializedName("node_id")
    var nodeId: String,
    @SerializedName("notifications_url")
    var notificationsUrl: String,
    @SerializedName("open_issues")
    var openIssues: Int,
    @SerializedName("open_issues_count")
    var openIssuesCount: Int,
    @SerializedName("owner")
    var owner: Owner,
    @SerializedName("private")
    var `private`: Boolean,
    @SerializedName("pulls_url")
    var pullsUrl: String,
    @SerializedName("pushed_at")
    var pushedAt: String,
    @SerializedName("releases_url")
    var releasesUrl: String,
    @SerializedName("size")
    var size: Int,
    @SerializedName("ssh_url")
    var sshUrl: String,
    @SerializedName("stargazers_count")
    var stargazersCount: Int,
    @SerializedName("stargazers_url")
    var stargazersUrl: String,
    @SerializedName("statuses_url")
    var statusesUrl: String,
    @SerializedName("subscribers_url")
    var subscribersUrl: String,
    @SerializedName("subscription_url")
    var subscriptionUrl: String,
    @SerializedName("svn_url")
    var svnUrl: String,
    @SerializedName("tags_url")
    var tagsUrl: String,
    @SerializedName("teams_url")
    var teamsUrl: String,
    @SerializedName("trees_url")
    var treesUrl: String,
    @SerializedName("updated_at")
    var updatedAt: String,
    @SerializedName("url")
    var url: String,
    @SerializedName("watchers")
    var watchers: Int,
    @SerializedName("watchers_count")
    var watchersCount: Int
) {
    data class License(
        @SerializedName("key")
        var key: String,
        @SerializedName("name")
        var name: String,
        @SerializedName("node_id")
        var nodeId: String,
        @SerializedName("spdx_id")
        var spdxId: String,
        @SerializedName("url")
        var url: String
    )

    data class Owner(
        @SerializedName("avatar_url")
        var avatarUrl: String,
        @SerializedName("events_url")
        var eventsUrl: String,
        @SerializedName("followers_url")
        var followersUrl: String,
        @SerializedName("following_url")
        var followingUrl: String,
        @SerializedName("gists_url")
        var gistsUrl: String,
        @SerializedName("gravatar_id")
        var gravatarId: String,
        @SerializedName("html_url")
        var htmlUrl: String,
        @SerializedName("id")
        var id: Int,
        @SerializedName("login")
        var login: String,
        @SerializedName("node_id")
        var nodeId: String,
        @SerializedName("organizations_url")
        var organizationsUrl: String,
        @SerializedName("received_events_url")
        var receivedEventsUrl: String,
        @SerializedName("repos_url")
        var reposUrl: String,
        @SerializedName("site_admin")
        var siteAdmin: Boolean,
        @SerializedName("starred_url")
        var starredUrl: String,
        @SerializedName("subscriptions_url")
        var subscriptionsUrl: String,
        @SerializedName("type")
        var type: String,
        @SerializedName("url")
        var url: String
    )
}