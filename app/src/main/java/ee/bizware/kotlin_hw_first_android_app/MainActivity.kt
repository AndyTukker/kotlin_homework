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
        val firstPost = Post("Братья Гамбс", "Этим полукреслом мастер Гамбс начинает новую партию мебели", "12 августа 1865", likedByMe = true, quantityOfLikes = 50, quantityOfShares = 3)
        createdTv.text = firstPost.created
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

}
