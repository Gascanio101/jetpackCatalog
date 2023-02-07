package com.example.jetpackcomponentcatalog.ui

data class CheckboxInfo(val title: String, val selected: Boolean = false, var onCheckedChange: (Boolean) -> Unit)