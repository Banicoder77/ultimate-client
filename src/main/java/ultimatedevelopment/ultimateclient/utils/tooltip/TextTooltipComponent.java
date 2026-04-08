/*
 * This file is part of the Ultimate Client distribution (https://github.com/Banicoder77/ultimate-client).
 * Copyright (c) Banicoder77.
 */

package ultimatedevelopment.ultimateclient.utils.tooltip;

import net.minecraft.client.gui.tooltip.OrderedTextTooltipComponent;
import net.minecraft.client.gui.tooltip.TooltipComponent;
import net.minecraft.text.OrderedText;
import net.minecraft.text.Text;

public class TextTooltipComponent extends OrderedTextTooltipComponent implements UltimateTooltipData {
    public TextTooltipComponent(OrderedText text) {
        super(text);
    }

    public TextTooltipComponent(Text text) {
        this(text.asOrderedText());
    }

    @Override
    public TooltipComponent getComponent() {
        return this;
    }
}
