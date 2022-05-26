package br.com.gds.osservices.activity

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.NonNull
import org.jetbrains.annotations.NotNull
import java.util.*
import kotlin.collections.ArrayList

fun Activity.nextScreen(
    @NotNull activity: Activity
) {
    Intent(this, activity::class.java).apply {
        executeIntent(this)
    }
}

fun <T> Activity.nextScreenExtras(
    @NotNull activity: Activity,
    @NotNull name: String,
    @NotNull vararg value: T
) {
    Intent(activity.applicationContext, activity::class.java).apply {
        this.putExtra(name, value)
        executeIntent(this)
    }
}

fun <T> Activity.nextScreenBundle(
    @NotNull activity: Activity,
    @NotNull bundle: Bundle
) {
    Intent(activity.applicationContext, activity::class.java).apply {
        this.putExtras(bundle)
        executeIntent(this)
    }

}

fun <T> Activity.nextScreenFromClass(
    @NotNull activity: Activity,
    @NotNull name: String,
    @NotNull value: Class<T>
) {
    Intent(activity.applicationContext, activity::class.java).apply {
        this.putExtra(name, value)
        executeIntent(this)
    }
}

fun Activity.nextScreenForResult(
    @NotNull activity: Activity
) {
    Intent(activity.applicationContext, activity::class.java).apply {
        startActivityForResult(this, 1)
    }
}

fun Activity.nextScreenForResultBundle(
    @NotNull activity: Activity,
    @NotNull bundle: Bundle
) {
    Intent(activity.applicationContext, activity::class.java).apply {
        startActivityForResult(this, 1, bundle)
    }
}

fun Activity.playMusic(music: String) {
    val uri = Uri.parse(music)
    val i = Intent()
    i.apply {
        action = Intent.ACTION_VIEW
        setDataAndType(uri, "audio/mp3")
        executeIntent(this)
    }
}

fun Activity.sendMessage(
    @NotNull number: String,
    @NotNull msg: String
) {
    val uri = Uri.parse("sms:$number")
    val it = Intent(Intent.ACTION_VIEW, uri).putExtra("sms_body", msg)
    executeIntent(it)
}

fun Activity.senEmail(para: String, assunto: String, msg: String) {
    val it = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", para, null))
    it.apply {
        putExtra(Intent.EXTRA_SUBJECT, assunto)
        putExtra(Intent.EXTRA_TEXT, msg)
        executeIntent(Intent.createChooser(this, "Send Email:"))
    }
}

fun Activity.openMapLocation(latlog: String) {
    val GEO_URI = "geo:$latlog"
    val it = Intent(Intent.ACTION_VIEW, Uri.parse(GEO_URI))
    executeIntent(it)
}

fun Activity.openContacts() {
    Intent(Intent.ACTION_VIEW, Uri.parse("content://com.android.contacts/contacts")).apply {
        executeIntent(this)
    }
}

fun Activity.openContactsWithId(id: Int) {
    Intent(Intent.ACTION_VIEW, Uri.parse("content://com.android.contacts/contacts/$id")).apply {
        executeIntent(this)
    }
}

fun Activity.getContact() {
    Intent(Intent.ACTION_VIEW, Uri.parse("content://com.android.contacts/contacts")).apply {
        startActivityForResult(this, 1)
    }

//    //necessario o onActivityResult
}
//na activity coloque
//    override fun onActivityResult(requestCode: Int, resultCode, Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == 1 && resultCode == RESULT_OK) {
//            val uri = data?.data
//        }
//    }
fun Activity.message(msg : String ,duration : Int = Toast.LENGTH_LONG){
    Toast.makeText(this,msg,duration).show()
}
fun Activity.executeIntent(intent: Intent){
    if(intent.resolveActivity(packageManager) != null){
        startActivity(intent)
    }else{
        message("Erro")
    }
}