package com.hackaton.entity

data class ItemSelection(
    val id: Int,
    val title: String?,
    val onClickFunc: (type: Int) -> Unit?
)
