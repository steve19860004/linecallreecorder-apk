/*
 * CallVault: FOSS call recording, self-contained over embedded ADB
 *  Copyright (C) 2026-present The CallVault Authors
 *  This software is licensed under the GNU General Public License v3 or later, with additional terms as permitted under Section 7.
 *  The full license text is available in the LICENSE file at the root of this project.
 *  This software is distributed WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 */

package com.steve.linecallrec.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steve.linecallrec.R
import com.steve.linecallrec.ui.common.CvCard
import com.steve.linecallrec.ui.common.HonorDialerHint
import com.steve.linecallrec.ui.common.M3DropdownField
import com.steve.linecallrec.ui.common.OptionItem
import com.steve.linecallrec.utils.FILE_NAME_TEMPLATE_PRESETS
import com.steve.linecallrec.utils.HONOR_DIALER_TEMPLATE
import com.steve.linecallrec.utils.fileNameTemplateExample
import com.steve.linecallrec.utils.presetForTemplateOrFirst

@Composable
internal fun FileNameStep(
    template: String,
    settingsVersion: Int,
    onSelectTemplate: (String) -> Unit
) {
    // Friendly preset label as primary text + a resolved example as the per-item preview line —
    // never the raw "{token}" template.
    val options = FILE_NAME_TEMPLATE_PRESETS.map {
        OptionItem(
            key = it.template,
            label = stringResource(it.labelRes),
            description = stringResource(
                R.string.settings_file_name_template_example,
                fileNameTemplateExample(it.template)
            )
        )
    }
    val selectedTemplate = presetForTemplateOrFirst(template).template

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        CvCard(contentPadding = PaddingValues(vertical = 8.dp)) {
            M3DropdownField(
                label = stringResource(R.string.settings_file_name_template_preset),
                selected = options.find { it.key == selectedTemplate } ?: options.first(),
                options = options,
                onOptionSelected = { onSelectTemplate(it.key) }
            )
        }
        // The live preview of the chosen name: a value, not an explanation, so it stays on screen.
        SettingsHint(
            stringResource(
                R.string.settings_file_name_template_example,
                fileNameTemplateExample(selectedTemplate)
            )
        )
        if (selectedTemplate == HONOR_DIALER_TEMPLATE) {
            CvCard { HonorDialerHint(refreshKey = settingsVersion) }
        }
    }
}
