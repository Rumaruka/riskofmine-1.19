package com.rumaruka.riskofmine.common.items.legendary;

import com.rumaruka.riskofmine.api.Category;
import com.rumaruka.riskofmine.api.Types;
import com.rumaruka.riskofmine.common.items.BaseCollectablesItem;
import com.rumaruka.riskofmine.utils.ROMUtils;

public class AlienHeadItem extends BaseCollectablesItem {
    public int cooldownMinus;
    public AlienHeadItem() {
        super(Types.LEGENDARY, Category.UTILITY, 64);
        this.cooldownMinus= ROMUtils.getStack(this).getCount()*100;
    }
}
