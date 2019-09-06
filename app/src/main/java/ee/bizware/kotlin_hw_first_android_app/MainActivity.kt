package ee.bizware.kotlin_hw_first_android_app

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ee.bizware.kotlin_hw_first_android_app.dto.Post
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val firstPost = Post(
            author = "Братья Гамбс",
            content = "Этим полукреслом мастер Гамбс начинает новую партию мебели",
            created = "12 августа 1865",
            createdTimeStamp = 1567770000,
            likedByMe = true,
            quantityOfLikes = 50,
            quantityOfShares = 3)
        val currentMoment = System.currentTimeMillis()/1000
        createdTv.text = timeInSecondsToString(currentMoment - firstPost.createdTimeStamp)
        authorTv.text = firstPost.author
        contentTv.text = firstPost.content
        //
        if (firstPost.quantityOfLikes == 0) {
            quantityOfLikesTv.text = ""
        }
        else {
            quantityOfLikesTv.text = firstPost.quantityOfLikes.toString()
        }
        if (firstPost.likedByMe){
            quantityOfLikesTv.setTextColor(Color.RED)
            likeTg.isChecked = true
        }
        //
        if (firstPost.quantityOfComments == 0) {
            quantityOfCommentsTv.text = ""
        }
        else {
            quantityOfCommentsTv.text = firstPost.quantityOfComments.toString()
        }
        if (firstPost.commentedByMe) {
            quantityOfCommentsTv.setTextColor(Color.RED)
            commentTg.isChecked = true
        }
        //
        if (firstPost.quantityOfShares == 0) {
            quantityOfSharesTv.text = ""
        }
        else {
            quantityOfSharesTv.text = firstPost.quantityOfShares.toString()
        }
        if (firstPost.sharedByMe) {
            quantityOfSharesTv.setTextColor(Color.RED)
            shareTg.isChecked = true
        }
    }

    fun timeInSecondsToString(sec : Long) : String {
        val oneMinute = 60
        val oneHour = oneMinute * 60
        val oneDay = oneHour * 24
        val oneMounth = oneDay * 30
        val oneYear = oneMounth * 12
        val publishedAgo: String = when {
            (sec > oneYear * 2) -> "Some years ago"
            (sec > oneYear) -> "One year ago"
            (sec >= oneMounth * 2) -> "" + (sec / oneMounth) + " months ago"
            (sec >= oneMounth) -> "One month ago"
            (sec >= oneDay * 2) -> "" + (sec / oneDay) + " days ago"
            (sec >= oneDay) -> "One day ago"
            (sec >= oneHour * 2) -> "" + (sec / oneHour) + " hours ago"
            (sec >= oneHour) -> "One hour ago"
            (sec >= oneMinute * 2) -> "" + (sec / oneMinute) + " minutes ago"
            (sec >= oneMinute) -> "One minute ago"
            else -> "less than a minute ago"
        }
        return publishedAgo
    }
}
