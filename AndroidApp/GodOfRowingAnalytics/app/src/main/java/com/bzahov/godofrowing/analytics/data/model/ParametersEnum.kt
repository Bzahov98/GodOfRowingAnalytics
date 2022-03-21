package com.bzahov.godofrowing.analytics.data.model

import com.bzahov.godofrowing.analytics.R
import java.sql.Types.DOUBLE
import kotlin.reflect.KClass
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

enum class ParametersEnum(
    val parameterDimensionTitle: Int = R.string.activity_parameter_default,
    val parameterCategory: DimensionCategories = DimensionCategories.DEFAULT,
    val parameterUnit: DimensionUnits = DimensionUnits.DEFAULT,
) {
    DISTANCE_METERS(R.string.activity_parameter_distance,
        DimensionCategories.DISTANCE,
        DimensionUnits.METERS
    ),
    DISTANCE_KM(R.string.activity_parameter_distance,
        DimensionCategories.DISTANCE,
        DimensionUnits.KILOMETERS
    ),
    HEART_RATE(R.string.activity_parameter_heart_rate,
        DimensionCategories.HEARTBEATS,
        DimensionUnits.HEARTBEATS_IN_MINUTE
    ),
}

enum class DimensionCategories() {
    SPEED,
    DISTANCE,
    HEARTBEATS,
    DEFAULT
}

enum class DimensionUnits(val dimensionUnitName: Int = R.string.activity_parameter_unit_default, val unit: KClass<*>) {
    // SPEED
    @ExperimentalTime
    TIME_PER_500M(R.string.activity_parameter_unit_time_per_meters, Duration::class),
    METER_PER_SECOND(R.string.activity_parameter_unit_meter_per_sec,DOUBLE::class),
//    KM_PER_HOUR(R.string.activity_parameter_,DOUBLE::class),
//    MILLIS_PER_HOUR(DOUBLE::class),

    // DISTANCE
    METERS(R.string.activity_parameter_unit_meters,DOUBLE::class),
//    MILES(R.string.activity_parameter_,DOUBLE::class),
    KILOMETERS(R.string.activity_parameter_unit_kilometers,DOUBLE::class),

    //    HEARTBEATS
    HEARTBEATS_IN_MINUTE(R.string.activity_parameter_unit_heart_beats_min,Int::class),

    DEFAULT(R.string.activity_parameter_unit_default, String::class),

}