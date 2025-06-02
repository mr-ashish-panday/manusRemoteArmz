package com.remotearmz.commandcenter.ui.components.charts

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.github.mikephil.charting.charts.*
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.ValueFormatter

@Composable
fun RevenueLineChart(
    modifier: Modifier = Modifier,
    data: List<Pair<String, Float>> = generateSampleRevenueData(),
    label: String = "Monthly Revenue"
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {
        AndroidView(
            factory = { context ->
                LineChart(context).apply {
                    description.isEnabled = false
                    setTouchEnabled(true)
                    isDragEnabled = true
                    setScaleEnabled(true)
                    setPinchZoom(true)
                    setDrawGridBackground(false)
                    setDrawBorders(false)
                    setNoDataText("No revenue data available")
                    
                    // Configure X-axis
                    xAxis.position = XAxis.XAxisPosition.BOTTOM
                    xAxis.setDrawGridLines(false)
                    xAxis.textColor = MaterialTheme.colorScheme.onSurfaceVariant.toArgb()
                    xAxis.textSize = 10f
                    
                    // Configure Y-axis
                    axisLeft.setDrawGridLines(true)
                    axisLeft.gridColor = MaterialTheme.colorScheme.outlineVariant.toArgb()
                    axisLeft.textColor = MaterialTheme.colorScheme.onSurfaceVariant.toArgb()
                    axisRight.isEnabled = false
                    
                    legend.isEnabled = false
                }
            },
            update = { chart ->
                val entries = data.mapIndexed { index, pair ->
                    Entry(index.toFloat(), pair.second, pair.first)
                }
                
                val dataSet = LineDataSet(entries, label).apply {
                    color = MaterialTheme.colorScheme.primary.toArgb()
                    lineWidth = 2.5f
                    setDrawCircles(true)
                    setDrawCircleHole(false)
                    circleRadius = 4f
                    circleHoleRadius = 2f
                    setCircleColor(MaterialTheme.colorScheme.primary.toArgb())
                    valueTextSize = 10f
                    valueTextColor = MaterialTheme.colorScheme.onSurfaceVariant.toArgb()
                    mode = LineDataSet.Mode.CUBIC_BEZIER
                    cubicIntensity = 0.2f
                    setDrawFilled(true)
                    fillDrawable = android.graphics.drawable.ColorDrawable(
                        MaterialTheme.colorScheme.primary.copy(alpha = 0.1f).toArgb()
                    )
                    setDrawValues(false)
                }
                
                chart.xAxis.valueFormatter = object : ValueFormatter() {
                    override fun getFormattedValue(value: Float): String {
                        return if (value >= 0 && value < data.size) {
                            data[value.toInt()].first
                        } else ""
                    }
                }
                
                chart.data = LineData(dataSet)
                chart.invalidate()
            }
        )
    }
}

@Composable
fun ProgressDonutChart(
    modifier: Modifier = Modifier,
    progress: Float,
    label: String = "Progress"
) {
    Box(
        modifier = modifier
            .size(150.dp)
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        AndroidView(
            factory = { context ->
                PieChart(context).apply {
                    setUsePercentValues(true)
                    description.isEnabled = false
                    setDrawEntryLabels(false)
                    setDrawHoleEnabled(true)
                    setHoleColor(android.graphics.Color.TRANSPARENT)
                    setTransparentCircleAlpha(0)
                    holeRadius = 70f
                    setDrawCenterText(true)
                    rotationAngle = 0f
                    isRotationEnabled = false
                    setTouchEnabled(false)
                    legend.isEnabled = false
                }
            },
            update = { chart ->
                val entries = listOf(
                    PieEntry(progress, "Completed"),
                    PieEntry(1f - progress, "Remaining")
                )
                
                val dataSet = PieDataSet(entries, "").apply {
                    colors = listOf(
                        MaterialTheme.colorScheme.primary.toArgb(),
                        MaterialTheme.colorScheme.surfaceVariant.toArgb()
                    )
                    setDrawValues(false)
                }
                
                chart.data = PieData(dataSet)
                chart.centerText = "${(progress * 100).toInt()}%"
                chart.setCenterTextSize(18f)
                chart.setCenterTextColor(MaterialTheme.colorScheme.primary.toArgb())
                chart.invalidate()
            }
        )
    }
}

@Composable
fun ConversionBarChart(
    modifier: Modifier = Modifier,
    data: List<Pair<String, Float>> = generateSampleConversionData()
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(220.dp)
    ) {
        AndroidView(
            factory = { context ->
                BarChart(context).apply {
                    description.isEnabled = false
                    setTouchEnabled(true)
                    setPinchZoom(false)
                    setDrawBarShadow(false)
                    setDrawGridBackground(false)
                    setDrawBorders(false)
                    
                    xAxis.position = XAxis.XAxisPosition.BOTTOM
                    xAxis.setDrawGridLines(false)
                    xAxis.textColor = MaterialTheme.colorScheme.onSurfaceVariant.toArgb()
                    xAxis.textSize = 10f
                    xAxis.granularity = 1f
                    xAxis.isGranularityEnabled = true
                    
                    axisLeft.setDrawGridLines(true)
                    axisLeft.gridColor = MaterialTheme.colorScheme.outlineVariant.toArgb()
                    axisLeft.textColor = MaterialTheme.colorScheme.onSurfaceVariant.toArgb()
                    axisLeft.axisMinimum = 0f
                    axisRight.isEnabled = false
                    
                    legend.isEnabled = false
                    setFitBars(true)
                }
            },
            update = { chart ->
                val entries = data.mapIndexed { index, pair ->
                    BarEntry(index.toFloat(), pair.second, pair.first)
                }
                
                val dataSet = BarDataSet(entries, "Conversion Rate").apply {
                    color = MaterialTheme.colorScheme.secondary.toArgb()
                    valueTextSize = 10f
                    valueTextColor = MaterialTheme.colorScheme.onSurfaceVariant.toArgb()
                    setDrawValues(true)
                    valueFormatter = object : ValueFormatter() {
                        override fun getFormattedValue(value: Float): String {
                            return "${value.toInt()}%"
                        }
                    }
                }
                
                chart.xAxis.valueFormatter = object : ValueFormatter() {
                    override fun getFormattedValue(value: Float): String {
                        return if (value >= 0 && value < data.size) {
                            data[value.toInt()].first
                        } else ""
                    }
                    
                    override fun getAxisLabel(value: Float, axis: AxisBase?): String {
                        return getFormattedValue(value)
                    }
                }
                
                chart.data = BarData(dataSet).apply {
                    barWidth = 0.5f
                }
                chart.invalidate()
            }
        )
    }
}

// Sample data generators
private fun generateSampleRevenueData(): List<Pair<String, Float>> {
    return listOf(
        "Jan" to 12000f,
        "Feb" to 15000f,
        "Mar" to 18000f,
        "Apr" to 22000f,
        "May" to 19000f,
        "Jun" to 25000f,
        "Jul" to 28000f
    )
}

private fun generateSampleConversionData(): List<Pair<String, Float>> {
    return listOf(
        "Week 1" to 15f,
        "Week 2" to 22f,
        "Week 3" to 18f,
        "Week 4" to 30f,
        "This Week" to 25f
    )
}
