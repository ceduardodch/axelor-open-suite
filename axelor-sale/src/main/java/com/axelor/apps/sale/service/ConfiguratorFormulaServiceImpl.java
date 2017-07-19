/**
 * Axelor Business Solutions
 * <p>
 * Copyright (C) 2017 Axelor (<http://axelor.com>).
 * <p>
 * This program is free software: you can redistribute it and/or  modify
 * it under the terms of the GNU Affero General Public License, version 3,
 * as published by the Free Software Foundation.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * <p>
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.axelor.apps.sale.service;

import com.axelor.apps.sale.db.ConfiguratorCreator;
import com.axelor.apps.sale.db.ConfiguratorFormula;
import com.axelor.meta.db.MetaField;

public class ConfiguratorFormulaServiceImpl implements ConfiguratorFormulaService {

    @Override
    public MetaField getMetaField(ConfiguratorFormula configuratorFormula) {
        ConfiguratorCreator configuratorCreator =configuratorFormula.getCreator();
        if (configuratorCreator == null) {
            return null;
        }

        if (configuratorCreator.getGenerateProduct()) {
            return configuratorFormula.getProductMetaField();
        } else {
            return configuratorFormula.getSaleOrderLineMetaField();
        }
    }
}
