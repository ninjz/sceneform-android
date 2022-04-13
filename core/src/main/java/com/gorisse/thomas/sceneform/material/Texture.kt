package com.gorisse.thomas.sceneform.material

import com.google.android.filament.Skybox
import com.google.android.filament.Texture
import com.google.ar.sceneform.rendering.EngineInstance
import com.gorisse.thomas.sceneform.Filament

fun <R> Texture.use(block: (Texture) -> R): R = block(this).also { destroy() }

/**
 * @see Skybox.Builder.build
 */
fun Texture.Builder.build(): Texture = build(Filament.engine)

/**
 * Destroys a Texture and frees all its associated resources.
 */
fun Texture.destroy() {
    EngineInstance.getEngine().filamentEngine.destroyTexture(this)
}