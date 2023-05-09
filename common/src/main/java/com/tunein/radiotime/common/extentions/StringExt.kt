package com.tunein.radiotime.common.extentions

import java.net.URLEncoder

fun String.encodeUrl(): String = URLEncoder.encode(this, "utf-8")