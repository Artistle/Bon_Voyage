package com.hackaton.entity

import java.util.Date

data class Habitation(
    val name: String?,
    val previewUrl: String?,
    val numberOfRooms: Int?,
    val floor: Int?,
    val maxFloorInBuilding: Int?,
    val startDate: Date?,
    val endDate: Date?,
    val ownerIcon: String?,
    val ownerName: String?
)