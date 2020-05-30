package race.mamba.samplenoti

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var manager: NotificationManager? = null

    private val CHANNEL_ID = "channel1"
    private val CHANNEL_NAME = "Channel1"

    private val CHANNEL_ID2="channel2"
    private val CHANNEL_NAME2="Channel2"

    private val CHANNEL_ID3="channel3"
    private val CHANNEL_NAME3="Channel3"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            showNoti1()
        }

        button2.setOnClickListener {
            showNoti2()
        }

        button3.setOnClickListener {
            showNoti3()
        }
    }


    private fun showNoti3(){
        manager=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        var builder:NotificationCompat.Builder?=null
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            manager!!.createNotificationChannel(NotificationChannel(
                    CHANNEL_ID2, CHANNEL_NAME2, NotificationManager.IMPORTANCE_DEFAULT
            ))
            builder = NotificationCompat.Builder(this, CHANNEL_ID2)
        }else{
            builder=NotificationCompat.Builder(this)
        }

        val intent=Intent(this,MainActivity::class.java)
        val pendingIntent=PendingIntent.getActivity(this,101,intent,PendingIntent.FLAG_CANCEL_CURRENT)

        val style=NotificationCompat.BigTextStyle()
        style.bigText("간장공장공장장은 간공장장이고")
        style.setBigContentTitle("제목입니다")
        style.setSummaryText("요약글자입니다")

        builder.setContentTitle("간단알림")
        builder.setContentText("알림 메시지입니다")
        builder.setSmallIcon(android.R.drawable.ic_menu_view)
        builder.setAutoCancel(true)
        builder.setContentIntent(pendingIntent)
        builder.setStyle(style)

        val noti=builder.build()
        manager!!.notify(2,noti)


    }



    fun showNoti2(){
        manager=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        var builder:NotificationCompat.Builder?=null
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            manager!!.createNotificationChannel(NotificationChannel(
                    CHANNEL_ID2, CHANNEL_NAME2, NotificationManager.IMPORTANCE_DEFAULT
            ))
            builder = NotificationCompat.Builder(this, CHANNEL_ID2)
        }else{
            builder=NotificationCompat.Builder(this)
        }

        val intent=Intent(this,MainActivity::class.java)
        val pendingIntent=PendingIntent.getActivity(this,101,intent,PendingIntent.FLAG_CANCEL_CURRENT)

        builder.setContentTitle("간단알림")
        builder.setContentText("알림 메시지입니다")
        builder.setSmallIcon(android.R.drawable.ic_menu_view)
        builder.setAutoCancel(true)
        builder.setContentIntent(pendingIntent)
        val noti=builder.build()
        manager!!.notify(2,noti)

        val style=NotificationCompat.BigTextStyle()
        style.bigText("많은 글자들입니다")
        style.setBigContentTitle("제목입니다")
        style.setSummaryText("요약글자입니다")

        val builder2 = NotificationCompat.Builder(this, "channel3")
                .setContentTitle("알림 제목")
                .setContentText("알림 내용")
                .setSmallIcon(android.R.drawable.ic_menu_send)
                .setStyle(style)

    }


    fun showNoti1() {
        manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        var builder: NotificationCompat.Builder? = null
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //if (manager!!.getNotificationChannel(CHANNEL_ID) != null) {
                manager!!.createNotificationChannel(NotificationChannel(
                        CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT
                ))
                builder = NotificationCompat.Builder(this, CHANNEL_ID)
           // }
        } else {
            builder = NotificationCompat.Builder(this)
        }
        builder!!.setContentTitle("간단알림")
        builder.setContentText("알림 메시지입니다.")
        builder.setSmallIcon(android.R.drawable.ic_menu_view)
        val noti: Notification = builder.build()
        manager!!.notify(1, noti)
    }
}
