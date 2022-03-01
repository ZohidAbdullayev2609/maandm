package com.example.maandm.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.maandm.R
import com.example.maandm.adapter.MyRecycleAdapter
import com.example.maandm.databinding.FragmentFirstBinding
import com.example.maandm.model.Person
import java.util.*

class FirstFragment : Fragment() {

    private lateinit var _binding: FragmentFirstBinding
    private val binding get() = _binding
    private lateinit var list: ArrayList<Person>

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        initList()

        binding.rv.adapter =
            MyRecycleAdapter(requireContext(), list, object : MyRecycleAdapter.OnClick{
                override fun onClickListener(position: Int) {
                    val secondFragment = SecondFragment()
                    val bundle = Bundle()
                    bundle.putSerializable("position", list[position])
                    secondFragment.arguments = bundle
                    val transaction = fragmentManager?.beginTransaction()
                    transaction?.replace(R.id.container, secondFragment)?.commit()
                }
            })

        return binding.root
    }

    private fun initList() {
        list = ArrayList()
        for (i in 0..10) {
            list.add(
                Person(
                    R.drawable.minor,
                    "Minor masjidi",
                    "Minor masjidi - Toshkent shahrida yangi qurilgan masjid. Masjidning qurilish ishlari 2013-yil yoz oylarida boshlangan. 2014-yilning 1-oktyabrida, musulmonlarning katta Qurbon hayiti bayramida Oʻzbekiston Prezidenti Islom Karimov yangi Minor masjidini ochib berdi. Masjid binosi anʼanaviy sharq va oʻzbek uslubida qurilgan boʻlib, ikki minorasi va osmonrang bir gumbaz bor. Masjidning ichi esa naqsh tarzida bezatilgan. Masjid 2400 dan ortiq odamlar uchun moʻljallangan. Ochilganidan soʻng „Minor“ masjidi Toshkentda va butun Oʻzbekiston boʻylab eng yirik musulmon diniy markazlaridan biriga aylandi. Masjidning qurilishi davlat byudjeti va Oʻzbekiston musulmonlari idorasi tomonidan moliyalashtiriladi. Masjidda sayyohlar uchun barcha shart-sharoitlar mavjud. U barcha zamonaviy jihozlar bilan jihozlangan.",
                    41.3353142, 69.2728463
                )
            )
            list.add(
                Person(
                    R.drawable.kokcha,
                    "Ko'kcha masjidi",
                    "\"Shayx Zayniddin\" jome' masjidi Mannon Uyg'ur ko'chasi 378-uyda joylashgan bo'lib, \"Ko'kcha\" mahallasi hududidadir. \"Shayx Zayniddin ota\" qabristoni va masjid taxminan 700 yillik tarixga ega. Professor Omonulla Fayzullaevning Shayx Zayniddin boboning tarixini o'rganish bo'yicha xulosasiga qaraganda, u zotning to'liq nomi Shayx Zayniddin Ko'yi Orifoni Toshkandiy ibn Shayx Shahobiddin Abu Hafs Umar Suhravardiy bo'lib, 1164 yilda tug'ilgan va 1259 yilda 95 yoshida vafot etgan. Otasi Shayx Shahobiddin Abu Hafs Umar Suxravardiy Iroq mamlakatining Xorazmshoh davlatidagi elchisi bo'lib, 25 yil xizmat qilgan. Shayx Zayniddin bobo shu davrda Xorazmdan Toshkentga kelib qolgan. Shayx Zayniddin bobo Toshkentga yaqinlashganida, shaharning Ko'kcha darvozasidan bir necha chaqirim narida tuya to'xtab cho'kadi. Shayx Zayniddin boboning maskaniga aylangan ushbu joy, keyinchalik, Ko'kcha dahasiga aylanadi va Orifon qishlog'i paydo bo'ladi. So'ngra bu erda Hazrati Shayx Zayniddin bobo dafn etilib, \"Shayx Zayniddin bobo\" qabristoniga aylanadi. Qabriston Toshkentning g'arbiy qismida. Maydoni 8-9 ga. Bu qabriston 19-asrda shahardagi eng yirik qabristonlardan biri bo'lgan. O'sha davrda u erda faqat chillaxona va hujralar, keyinchalik masjid qurilgan. U zotning o'limidan 132 yil keyin Sohibqiron Amir Temurning Shayx Zayniddin bobo qabri ziyorati natijasida ul zotga ixlos va hurmat ko'rsatib maqbara qurdirgan. Maqbara shu kungacha bir necha bor ta'mirlangan. Maqbaraning orqa tomonida \"Chillaxona\" – sakkiz tomonli, yuqorisi gumbaz sifatli bino qad ko'tarib turibdi. Salohiddin ibn Aloiddin Toshkandiyning \"Temurnoma\" kitobida shunday deyiladi: \"Amir Sohibqiron Turkiston ichra qabri shariflarga marqad ko'tarib, imorati oliy qurib, qancha erlarni vaqf qilib, andin keyin yana Hazrat Zayniddin Ko'yi Orifonga Kaykovus suvidan nahri azim chiqarib, qul-cho'ri birla nazr etib, qabrlari uzra gumbaz ko'tarib, andin keyin Zangi otani muborak qabrlarini bino qildilar.\n\n\"Sirli olam\" jurnalining 1998 yil avgust sonida Qahramon Nazarov tomonidan e'lon qilingan \"Shayx Zayniddin Ko'yi Orifon hazratlari\" va \"Toshkent oqshomi\"gazetasining 1998 yil sentyabr sonida Professor Omonulla Fayzullaev tomonidan e'lon qilingan \"Shayx Zayniddin bobo Toshkandiy haqida\" maqolalari bilan tanishgan kishi Shayx Zayniddin boboning nafaqat tariqat murshidi, balki falakiyot ilmining bilimdoni va er osti yo'li qurilishining muhandisi ekanligi haqida ham to'liqroq ma'lumotga ega bo'lish mumkin.\n\nO'zbekiston Musulmonlari Idorasiga qarashli \"Shayx Zayniddin\" jome' masjidi \"Shayx Zayniddin\" maqbarasi yonida joylashgani uchun, masjid 1943 yilda ochilgandan buyon shu nom bilan ataladi. Xalq tilida \"Ko'kcha\", jome' \"Shayx Zayniddin buva\" nomlari bilan yuritiladi. Masjid yonida 40-o'rta maktab, \"Ko'kcha\" qabristoni, 8-tramvay va 53, 46-avtobuslarning \"Ko'kcha\"bekati joylashgan. Masjidning qadimiy binosi 19-asrning oxirida qurilgani, masjid hovlisidan o'tgan anhor suvining ta'siri va Toshkent zilzilasining oqibatida yaroqsiz holga kelgani uchun masjid jamoasi uni qayta qurish uchun 1994 yil Toshkent shahar hokimligiga murojaat qildilar.",
                    41.3227668, 69.2026545
                )
            )
            list.add(
                Person(
                    R.drawable.hastimom,
                    "Xazrati Imom masjidi",
                    "Hazrati imom majmuasi, Hastimom — Toshkentdagi meʼmoriy yodgorlik (16—20-asrlar); majmua imom Abu Bakr Muhammad ibn Ali Ismoil ash-Qaffol Shoshiy qabri atrofida shakllangan. Qabr va uning atrofida vujudga kelgan qabriston va meʼmoriy yodgorlik majmuasi Hazrati imom nomi bilan ataladi. Dastlab Baroqxon madrasasi, keyinroq Qaffol Shoshiy maqbarasi, 16-asr oxirlarida Suyunchxoʻjaxon va nomaʼlum maqbara, 1579 yilda Abdullaxon II mablagʻiga qoʻsh uslubida Shayx bobohoji maqbarasi qurilgan (saqlan-magan). 16-asrda majmua tarkibida sayrgoh bogʻ barpo etilgan, ayvonlar qurilgan, hovuz atrofi koʻkalamzorlashtirilgan, xalq sayillari oʻtkazilgan. 19-asr oʻrtalarida Toshkent namozgohi (Tillashayx masjidi), Moʻyi Muborak madrasasi, Jome masjidi (saqlanmagan) bunyod etilgan. 20-asr boshlarida Tillashayx masjidi qayta qurilgan. Eshon Boboxon ham shu joyda dafn etilgan. Hazrati Imom majmuasim.da Oʻzbekiston musulmonlari idorasi joylashgan. \n\n 2007-yil boshida Prezidentimiz Farmoni bilan Hazrati Imom (Hastimom) jamoatchilik jamg‘armasi tashkil etilib, Hazrati Imom majmuasining asl tarixiy qiyofasini tiklash maqsadida bu yerda keng ko‘lamli qurilish-ta’mirlash va obodonchilik ishlari olib borildi.\n" +
                            "\n" +
                            "Xazrati Imomning yangi ko‘rinishi qadimiy an’analar asosida yaratilgan bo‘lib, u ikki gumbaz va ikki minoradan iborat. O‘ng minora xorazmlik ustalar, chap minora samarqandlik hunarmandlar tomonidan bunyod etilgan. Minoralarning uzunligi 53 metrni tashkil etadi. Masjidga kiraverishda sandal daraxtidan ishlangan 20 ta ganch tushirilgan ustunli ayvon joylashgan. Gumbazlar darchalarining alohida loyihalashtirilishi, quyosh nurlarining tongdan ufqqa qadar masjidni yoritib turishiga imkon yaratgan. Ikki gumbazning ichki qismi tilla suvi bilan yurgizilgan.",
                    41.337473,
                    69.2389091
                )
            )
            list.add(
                Person(
                    R.drawable.kokaldosh,
                    "Ko'kaldosh madrasasi",
                    "«Ko’kaldosh» madrasasi Toshkent shahridagi tarixiy obidalardan biri sanaladi. Muhammad Solih Qoraxo’ja Toshkandiyning «Tarixi jadidayi Toshkand» kitobida «Ko’kaldosh» madrasasini Darveshxon qurdirganini yozadi va shu kitobining ba’zi joylarida madrasani Darveshxon madrasasi deb ham ataydi. Madrasa 1551-1575 yillar orasida qurib ishga tushirilgan. Bunga dalil sifatida tarixchilar 1569-1570 yillarda yozilgan vaqfnomani keltiradilar. Unga ko’ra, Toshkent hokimi Sulton Darveshxon bir karvonsaroyni madrasaga vaqf qilib bergani aytilgan. \n\n«Ko’kaldosh» madrasasi Chorsu maydonidagi Shahriston tepaligida Xo’ja Ahror Valiy jome’ masjidining yonida an’anaviy sharq uslubiga rioya qilib bunyod etilgan. Uning keng hovlisi hujralar va ochiq ayvonlar bilan o’ralgan. Hujralar soni 38 ta bo’lib, dastlab qurilganda madrasa uch qavatdan iborat bo’lgan. Bosh fasad janubga qaragan, darvozadan kiraverishda chapda masjid, o’ngda darsxona joylashgan. Masjid va darsxonaning usti o’zaro kesishgan ravoqlar ustiga o’rnatilgan qo’sh ichki va tashqi gumbazlardan iborat bo’lgan. Peshtoq sirkor parchin va jilva naqshlar bilan bezatilgan. XVIII asrga kelib qarovsiz qolgan madrasa karvonsaroy sifatida foydalanilgan. 1830-1831 yillarda Toshkent hokimi Lashkar Beglarbegining davrida darsxona va masjid o’ngidagi nurab to’kila boshlagan zangori gumbazlari va ikkinchi qavatning g’ishtlari ko’chirib olinib, hozirgi kunda buzilib ketgan Beglarbegi madrasasi (bozorning yuqori qismida)ning qurilishida ishlatilgan. \n" +
                            "1866-1886 yillarda ro’y bergan zilzila natijasida madrasa peshtoqining yuqori qismi qulab tushadi va madrasa vayronaga aylanadi.\n" +
                            "1902-1903 yillarda Toshkent shahri aholisining xayriya mablag’lari hisobidan ta’mirlash ishlari olib boriladi. Mablag’ yetishmasligi sababli ta’mirlash ishlari to’xtab qolib, yodgorlik o’zining avvalgi holatiga qaytarilmadi.\n\nKo’kaldosh madrasasi va uning yonidagi Xo’ja Ahror Valiy jome’ masjidi 1865 yilda General Chernyaev boshchiligidagi Toshkentni zabt etishda qattiq shikastlandi.\n" +
                            "1886 yili rus muhandislari tomonidan xonaqolar va jome’ masjid qayta ta’mirlanish natijasida o’zining dastlabki me’moriy ko’rinishini tamoman yo’qotdi. \n" +
                            "Vaqt o’tishi bilan o’zaro urushlar, kuchli zilzilalar, binolarning turli maqsadlarda foydalanishi, bir necha bor qayta ta’mir qilinishi va qayta tiklanishi madrasaning dastlabki haqiqiy go’zalligini, muhtashamligini asta-sekin yo’qotib borgan.",
                    41.3234684,
                    69.2341486
                )
            )
        }
    }

}
