package ee.bizware.kotlin_hw_first_android_app.dto

class Post(
    val author: String,
    val content: String,
    val created: String,
    //
    var likedByMe: Boolean = false,
    var commentedByMe: Boolean = false,
    var sharedByMe: Boolean = false,
    //
    var quantityOfLikes: Int = 0,
    var quantityOfComments: Int = 0,
    var quantityOfShares: Int = 0
)