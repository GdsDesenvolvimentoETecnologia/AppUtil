package br.com.gds.osservices.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.annotation.NonNull
import org.jetbrains.annotations.NotNull

fun Activity.nextScreen(
    @NotNull activity: Activity
) {
    Intent(this, activity::class.java).apply {
        startActivity(this)
    }
}

fun <T> Activity.nextScreenExtras(
    @NotNull activity: Activity,
    @NotNull name: String,
    @NotNull vararg value: T
) {
    Intent(activity.applicationContext, activity::class.java).apply {
        this.putExtra(name, value)
        startActivity(this)
    }
}

fun <T> Activity.nextScreenBundle(
    @NotNull activity: Activity,
    @NotNull bundle: Bundle
) {
    Intent(activity.applicationContext, activity::class.java).apply {
        this.putExtras(bundle)
        startActivity(this)
    }

}

fun <T> Activity.nextScreenFromClass(
    @NotNull activity: Activity,
    @NotNull name: String,
    @NotNull value: Class<T>
) {
    Intent(activity.applicationContext, activity::class.java).apply {
        this.putExtra(name, value)
        startActivity(this)
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
