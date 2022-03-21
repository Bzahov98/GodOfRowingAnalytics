package com.bzahov.godofrowing.analytics.data.model

import com.bzahov.godofrowing.analytics.R

enum class IndicatorsEnum(
    private val id: String, // useless
    private val indicatorType: ParametersEnum,
    private val parameterIconID: Int /*ImageVector? = null*/,
    val size: IndicatorSizeEnum = IndicatorSizeEnum.BIG,
) {
    DISTANCE_IN_METERS("Distance", ParametersEnum.DISTANCE_METERS, R.drawable.ic_distance_24),
    DISTANCE_IN_KM("Distance in Km", ParametersEnum.DISTANCE_KM, R.drawable.ic_distance_24),
    HEART_RATE("Heart rate", ParametersEnum.HEART_RATE, R.drawable.ic_outline_monitor_heart_24);

    fun getIndicatorTittle() = indicatorType.parameterDimensionTitle // Speed (Time per 500m)
    fun getIndicatorDimensionName() = indicatorType.parameterUnit.dimensionUnitName // ave per 500 m
    fun getIndicatorIcon() = parameterIconID
}

enum class IndicatorSizeEnum() {
    SMALL,
    BIG,
}