package com.example.jetpackcomponentcatalog.ui

data class Starred(var starred: Boolean = false, var onStarred:(Boolean) -> Unit) {
}