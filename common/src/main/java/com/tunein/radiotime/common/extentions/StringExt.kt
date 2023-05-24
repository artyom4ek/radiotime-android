package com.tunein.radiotime.common.extentions

import java.net.URLEncoder

/**
 * Encode string as a URL using the UTF-8 encoding.
 * URL encoding is used to convert special characters and spaces in a URL into a valid format.
 */
fun String.encodeUrl(): String = URLEncoder.encode(this, "utf-8")