package scisrc.mobiledev.ecommercelayout.ui

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import scisrc.mobiledev.ecommercelayout.R

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageProfile: ImageView = view.findViewById(R.id.imageProfile)
        val textFullName: TextView = view.findViewById(R.id.textFullName)
        val textEmail: TextView = view.findViewById(R.id.textEmail)
        val textShippingAddress: TextView = view.findViewById(R.id.textShippingAddress)

        // Mock ข้อมูลผู้ใช้
        val mockFullName = "ธนาธิป ดวงกลาง"
        val mockEmail = "tanatip@example.com"
        val mockShippingAddress = "123/456 ถนนงามวงศ์วาน เขตบางเขน กรุงเทพฯ 78910"

        // ตั้งค่ารูปโปรไฟล์จาก drawable
        imageProfile.setImageResource(R.drawable.profile)

        // ตั้งค่าข้อมูลใน UI
        textFullName.text = mockFullName
        textEmail.text = mockEmail
        textShippingAddress.text = mockShippingAddress
    }
}
