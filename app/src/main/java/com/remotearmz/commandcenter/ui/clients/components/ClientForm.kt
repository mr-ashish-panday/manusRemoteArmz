package com.remotearmz.commandcenter.ui.clients.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.remotearmz.commandcenter.data.model.Client
import com.remotearmz.commandcenter.data.model.ClientStatus
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientForm(
    client: Client? = null,
    onSave: (Client) -> Unit,
    onCancel: () -> Unit
) {
    var name by remember { mutableStateOf(client?.name ?: "") }
    var company by remember { mutableStateOf(client?.company ?: "") }
    var phone by remember { mutableStateOf(client?.phone ?: "") }
    var email by remember { mutableStateOf(client?.email ?: "") }
    var contractValueUSD by remember { mutableStateOf(client?.contractValueUSD?.toString() ?: "0.0") }
    var status by remember { mutableStateOf(client?.status ?: ClientStatus.ACTIVE) }
    var expanded by remember { mutableStateOf(false) }
    
    var nameError by remember { mutableStateOf("") }
    var companyError by remember { mutableStateOf("") }
    var phoneError by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf("") }
    var contractValueError by remember { mutableStateOf("") }
    
    fun validate(): Boolean {
        var isValid = true
        
        if (name.isBlank()) {
            nameError = "Name is required"
            isValid = false
        } else {
            nameError = ""
        }
        
        if (company.isBlank()) {
            companyError = "Company is required"
            isValid = false
        } else {
            companyError = ""
        }
        
        if (phone.isBlank()) {
            phoneError = "Phone is required"
            isValid = false
        } else {
            phoneError = ""
        }
        
        if (email.isBlank()) {
            emailError = "Email is required"
            isValid = false
        } else {
            emailError = ""
        }
        
        try {
            contractValueUSD.toDouble()
            contractValueError = ""
        } catch (e: NumberFormatException) {
            contractValueError = "Invalid number format"
            isValid = false
        }
        
        return isValid
    }
    
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = if (client == null) "Add New Client" else "Edit Client",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            isError = nameError.isNotEmpty(),
            supportingText = { if (nameError.isNotEmpty()) Text(nameError) },
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        OutlinedTextField(
            value = company,
            onValueChange = { company = it },
            label = { Text("Company") },
            isError = companyError.isNotEmpty(),
            supportingText = { if (companyError.isNotEmpty()) Text(companyError) },
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        OutlinedTextField(
            value = phone,
            onValueChange = { phone = it },
            label = { Text("Phone") },
            isError = phoneError.isNotEmpty(),
            supportingText = { if (phoneError.isNotEmpty()) Text(phoneError) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            isError = emailError.isNotEmpty(),
            supportingText = { if (emailError.isNotEmpty()) Text(emailError) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        OutlinedTextField(
            value = contractValueUSD,
            onValueChange = { contractValueUSD = it },
            label = { Text("Contract Value (USD)") },
            isError = contractValueError.isNotEmpty(),
            supportingText = { if (contractValueError.isNotEmpty()) Text(contractValueError) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = it },
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = status.name,
                onValueChange = {},
                readOnly = true,
                label = { Text("Status") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor()
            )
            
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                ClientStatus.values().forEach { clientStatus ->
                    DropdownMenuItem(
                        text = { Text(clientStatus.name) },
                        onClick = {
                            status = clientStatus
                            expanded = false
                        }
                    )
                }
            }
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        Row(modifier = Modifier.fillMaxWidth()) {
            TextButton(
                onClick = onCancel,
                modifier = Modifier.weight(1f)
            ) {
                Text("Cancel")
            }
            
            Button(
                onClick = {
                    if (validate()) {
                        val updatedClient = Client(
                            id = client?.id ?: UUID.randomUUID().toString(),
                            name = name,
                            company = company,
                            phone = phone,
                            email = email,
                            contractValueUSD = contractValueUSD.toDoubleOrNull() ?: 0.0,
                            status = status,
                            createdAt = client?.createdAt ?: System.currentTimeMillis(),
                            updatedAt = System.currentTimeMillis()
                        )
                        onSave(updatedClient)
                    }
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Save")
            }
        }
    }
}
