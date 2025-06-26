package com.zmkn.kotlin.serializers.module.time

import com.zmkn.kotlin.serializers.module.time.serializers.InstantSerializer
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.SerializersModuleBuilder
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

object TimeKotlinSerializersModule {
    @OptIn(ExperimentalTime::class)
    val instantSerializersModuleBuilder = fun SerializersModuleBuilder.() {
        contextual(Instant::class, InstantSerializer)
    }

    val all: SerializersModule by lazy {
        generateModule(
            instantSerializersModuleBuilder,
        )
    }

    fun generateModule(vararg serializersModuleBuilder: SerializersModuleBuilder.() -> Unit): SerializersModule {
        return SerializersModule {
            serializersModuleBuilder.forEach {
                it()
            }
        }
    }
}
