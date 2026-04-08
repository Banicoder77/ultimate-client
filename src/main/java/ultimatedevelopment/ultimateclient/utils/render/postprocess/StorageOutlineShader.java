package ultimatedevelopment.ultimateclient.utils.render.postprocess;

import ultimatedevelopment.ultimateclient.renderer.MeshRenderer;
import ultimatedevelopment.ultimateclient.renderer.UltimateRenderPipelines;
import ultimatedevelopment.ultimateclient.systems.modules.Modules;
import ultimatedevelopment.ultimateclient.systems.modules.render.StorageESP;

public class StorageOutlineShader extends PostProcessShader {
    private static StorageESP storageESP;

    public StorageOutlineShader() {
        super(UltimateRenderPipelines.POST_OUTLINE);
    }

    @Override
    protected boolean shouldDraw() {
        if (storageESP == null) storageESP = Modules.get().get(StorageESP.class);
        return storageESP.isShader();
    }

    @Override
    protected void setupPass(MeshRenderer renderer) {
        renderer.uniform("OutlineData", OutlineUniforms.write(
            storageESP.outlineWidth.get(),
            storageESP.fillOpacity.get() / 255.0f,
            storageESP.shapeMode.get().ordinal(),
            storageESP.glowMultiplier.get().floatValue()
        ));
    }
}
