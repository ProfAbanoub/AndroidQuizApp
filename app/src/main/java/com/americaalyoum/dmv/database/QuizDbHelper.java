package com.americaalyoum.dmv.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.americaalyoum.dmv.database.QuizContract.QuestionsTable;
import com.americaalyoum.dmv.model.Question;

import java.util.ArrayList;

public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "dmvpermitpracticetest.db";
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;

    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER, " +
                QuestionsTable.COLUMN_DIFFICULTY + " TEXT" +
                ")";
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable() {
        // STATE_ILLINOIS_QUESTIONS
        Question q1 = new Question("عند القيادة مباشرة خلف شاحنة كبيرة. كيف يمكنك أن تحدد أنك غير موجود فى المنطقة العمياء للشاحنة؟",
                "عندما تكون تستطيع رؤية مرآة الشاحنة", "عندما لا تستطيع رؤية مرآة الشاحنة", "عندما لا تستطيع التحرك", 2, Question.STATE_ILLINOIS);
        addQuestion(q1);
        Question q2 = new Question("لا تحتاج أن توقف سيارتك لشاحنة المثلجات الايس كريم عندما",
                "إذا كنت على الجانب الآخر فى طريق سريع مزدوج أو في وسطها.", "اذا كنت علي نفس الجانب معها", "اذا كنت تقود بسرعة ولا يمكنك التوقف", 1, Question.STATE_ILLINOIS);
        addQuestion(q2);
        Question q3 = new Question("أفضل طريقة للتحدث مع السائقين الآخرين هي",
                "استخدام الهاتف المحمول", "استخدام اشارات اليد", "استخدام بوق سيارتك أو الأضواء", 3, Question.STATE_ILLINOIS);
        addQuestion(q3);
        Question q4 = new Question("لماذا يجب على السائق أن يحضر برنامج إدارة المرور لتحسين القيادة؟",
                "بسبب نظام النقاط", "بسبب تعلم القيادة", "لتحسين مهاراته", 1, Question.STATE_ILLINOIS);
        addQuestion(q4);
        Question q5 = new Question("ماذا تعني علامة المرور ذي الثمانية أضلاع؟",
                "علامة تنبيه لوجود تعرجات", "علامة هدئ السرعة", "علامة قف", 3, Question.STATE_ILLINOIS);
        addQuestion(q5);
        Question q6 = new Question("يجب الإبلاغ عن الرخصة المفقودةأو التالفة أو المسروقة خلال",
                "في نفس الوقت", "24 ساعة", "12 ساعة", 2, Question.STATE_ILLINOIS);
        addQuestion(q6);
        Question q7 = new Question("إذا تعطلت السيارة على الطريق السريع أول شئ يجب ان تفعله هو؟",
                "حاول أن تخرج من الطريق", "انتظر واتصل بالشرطة", "اتصل بصديق ليساعدك", 1, Question.STATE_ILLINOIS);
        addQuestion(q7);
        Question q8 = new Question("ما المسافة بالقدم التى يجب ان تبعد السيارة عندما تركنها فى الجهة المقابلة لمحطة الإطفاء؟",
                "85", "65", "75", 3, Question.STATE_ILLINOIS);
        addQuestion(q8);
        Question q9 = new Question("فى حالة تعطل إشارات الانعطاف عن العمل. ما هي أفضل طريقة تشير بأنك ستدير السيارة؟",
                "استخدام اضواء السيارة", "أستعمل إشارات اليد", "استخدام بوق السيارة", 2, Question.STATE_ILLINOIS);
        addQuestion(q9);
        Question q10 = new Question("إذا كنت ترغب فى العودة إلى الطريق الرئيسى من حافة الطريق ماذا تفعل؟",
                "اسرع ثم أدر العجلات لتصعد إلي الحافة", "أدر العجلات فقط", "أبطأ ثم أدر العجلات لتصعد الى الحافة", 3, Question.STATE_ILLINOIS);
        addQuestion(q10);
        Question q11 = new Question("لو تم ضبط راكب فى المقعد الامامى عمرة 17 سنة لا يرتدي حزام الأمان على من تكون المسؤولية؟",
                "السائق فقط", "الراكب فقط", "السائق والراكب معا", 1, Question.STATE_ILLINOIS);
        addQuestion(q11);
        Question q12 = new Question("ما هى الحالة الذهنية التي يتصف بها السائق الذى قاد السيارة لفترة طويلة أدى ذلك إلى حالة من فقدان الوعى اللحظى؟",
                "الخمول الذهني", "الخمول الجسدي", "التنويم الإيحائي أو التنويم المغناطيسي", 3, Question.STATE_ILLINOIS);
        addQuestion(q12);
        Question q13 = new Question("ما هو الخطأ الشائع والذى يرتكبه السائقون الجدد؟",
                "الضغط على الفرامل بقوة", "استخدام الأضواء بكثره", "عدم النظر للخلف", 1, Question.STATE_ILLINOIS);
        addQuestion(q13);
        Question q14 = new Question("للحصول على رخصة القيادة الأساسية يجب أن يكون عمر المراهق",
                "علي الأقل 16 سنة", "على الأقل 18 سنة", "علي الأقل 21 سنة", 2, Question.STATE_ILLINOIS);
        addQuestion(q14);
        Question q15 = new Question("لو تم ضبط الراكب (18 سنة واكثر) فى المقعد الامامى لا يرتدى حزام الامان من المسؤول؟",
                "الراكب فقط", "الراكب والسائق معا", "السائق فقط", 1, Question.STATE_ILLINOIS);
        addQuestion(q15);
        Question q16 = new Question("اذا انفجرت عجلة السيارة أثناء القيادة ماذا تفعل؟",
                "قم بالإتصال بالشرطة", "أترك السيارة علي الفور", "أترك السيارة تسير باستقامة للأمام و أبطئ قليلاً و بالتدريج أخرج من الطريق", 3, Question.STATE_ILLINOIS);
        addQuestion(q16);
        Question q17 = new Question("ترتيب الوان اشارة المرور معلقة من أعلى لأسفل",
                "الاحمر و الاصفر و الاخضر", "الاخضر والاصفر والاحمر", "الاحمر والاخضر والاصفر", 1, Question.STATE_ILLINOIS);
        addQuestion(q17);
        Question q18 = new Question("متى يجب على السائق أن يستعمل الأنوار الأمامية العالية؟",
                "خلال القيادة علي الطرق ذات التعرجات الكثيرة", "خلال القيادة بالقرب من مدرسة", "خلال القيادة في الأراضي المكشوفة وعلى الطرق السريعة خافتة الأضاءة", 3, Question.STATE_ILLINOIS);
        addQuestion(q18);
        Question q19 = new Question("للقيادة في المدينة هناك تصرفات جيدة منها …؟",
                "زيادة السرعة قدر الإمكان", "أنظر على الأقل من 12 الى 15 ثانية على الطريق لترى ما هو أمامك", "ابطأ السرعة عند المرور بجوار مدرسة او محطة بنزين", 2, Question.STATE_ILLINOIS);
        addQuestion(q19);
        Question q20 = new Question("عندما تركن السيارة. المسافة التي يجب أن تترك بعيد عن علامة قف هي .... قدم ؟",
                "50 قدم", "60 قدم", "40 قدم", 1, Question.STATE_ILLINOIS);
        addQuestion(q20);
        Question q21 = new Question("ما هى الاختبارات المطلوبة من الطالب ليمارس القيادة؟",
                "اختبار الظهر", "اختبار المعرفة و اختبار النظر", "اختبار الذكاء", 2, Question.STATE_ILLINOIS);
        addQuestion(q21);
        Question q22 = new Question("على أى الطرق يمكن أن توجد الخطوط المزدوجة الصلبة السميكة؟",
                "الطرق الكبيرة", "الطرق العامة", "طريق متعرج ذي اتجاهين", 3, Question.STATE_ILLINOIS);
        addQuestion(q22);
        Question q23 = new Question("عندما تركن سيارتك يجب ان تبتعد عن ممر الراجلين بـ .... قدم",
                "25", "20", "30", 1, Question.STATE_ILLINOIS);
        addQuestion(q23);
        Question q24 = new Question("عدم ارتدائك لحزام الأمان في المقعد الأمامي. وعدم احكام حزام الامان للطفل تحت 18 عام يعتبر ……؟",
                "ليست مخالفة", "مخالفة ثانوية", "مخالفة أساسية", 3, Question.STATE_ILLINOIS);
        addQuestion(q24);
        Question q25 = new Question("اذا كنت تقود سيارة بسرعة 50 ميل فى الساعة ما هي مسافة التوقف التي ستحتاجها لإيقاف السيارة وقوفا تاما",
                "257 قدم", "247 قدم", "267 قدم", 2, Question.STATE_ILLINOIS);
        addQuestion(q25);
        Question q26 = new Question("إذا اعتبرنا عجلة القيادة كأنها ساعة اليد أين يمكن وضع اليد ؟",
                "علي الرقم 5 و 11", "علي الرقم 4 و 10", "على الرقم 3 و 9", 3, Question.STATE_ILLINOIS);
        addQuestion(q26);
        Question q27 = new Question("الطريقة الأسلم للخروج من الطريق السريع هي",
                "أخرج من الطريق بسرعتك الحالية", " بطء السيارة إلى الحد الأقصى للسرعة", "أدر السيارة بسرعة للخروج من الطريق", 2, Question.STATE_ILLINOIS);
        addQuestion(q27);
        Question q28 = new Question("الحد الأقصى للسرعة في منطقة المدرسة هو :",
                "25 ميلا في الساعة", "30 ميلا في الساعة", "20 ميلا في الساعة", 1, Question.STATE_ILLINOIS);
        addQuestion(q28);
        Question q29 = new Question("متى يجب عليك تشغيل الاضواء الخافضة؟",
                "عند القيادة في منطقة مدرسة", "عند القيادة علي الطرق الكبيرة المتعرجة", "القيادة في المدينة وعند ملاحقة او مقابلة سيارة أخرى ضمن 500 قدم", 3, Question.STATE_ILLINOIS);
        addQuestion(q29);
        Question q30 = new Question("ما هو اسم المسافة التي تسير خلالها السيارة عند تطبيق الفرملة؟",
                "مسافة الحدود", "مسافة الفرملة", "مسافة النظام", 2, Question.STATE_ILLINOIS);
        addQuestion(q30);
        Question q31 = new Question("اين توجه عجلات سيارتك في منحنى؟",
                "كما هي", "إلي اليسار", "إلى اليمين", 3, Question.STATE_ILLINOIS);
        addQuestion(q31);
        Question q32 = new Question("يجوز إصدار رخصة خاصة لشخص عمره 16 سنة في الحالات التالية:",
                "المسجل في دورة تعليمية لتعليم القيادة", "لديه خبرة 3 سنوات في القيادة", "نظره سليم", 1, Question.STATE_ILLINOIS);
        addQuestion(q32);
        Question q33 = new Question("عندما تقترب من سكة الحدودية مع الأضواء الساطعة :",
                "قف على بعد 20 قدما من أقرب السكك الحديدية", "قف على بعد 15 قدما من أقرب السكك الحديدية", "قف علي بعد 10 أقدام من أقرب السكك الحديدية", 2, Question.STATE_ILLINOIS);
        addQuestion(q33);
        Question q34 = new Question("تشير الدراسات إلى أن أكبر عدد من الأشخاص الذين قبض عليهم بتهمة القيادة في حالة سكرنتيجة شربهم لهذا النوع  من المشروبات الكحولية؟",
                "البيرة", "الماء", "العصير", 1, Question.STATE_ILLINOIS);
        addQuestion(q34);
        Question q35 = new Question("لمن تعطي حق الاسبقية؟",
                "السيارات الخاصة", "سيارات الشرطة", "المشاة وسيارات الطوارئ", 3, Question.STATE_ILLINOIS);
        addQuestion(q35);


        // QUESTIONS_STATE_OHIO
        Question oQ1 = new Question("عند القيادة على الطريق السريع مقسمة إلى أربع حارات مرورية(ممرات) أي من العربات ينبغي ان تقف لحافلة المدرسة التي توقفت لانزال الأطفال",
                "العربات التي اقتربت فقط من الجزء الخلفي من الحافلة و تسير في نفس اتجاه الحافلة.", "العربة التي بجانب الحافلة", "العربات التي اقتربت فقط من الجزء الأمامي من الحافلة", 1, Question.STATE_OHIO);
        addQuestion(oQ1);
        Question oQ2 = new Question("يجب أن يتم التوقيع على طلب للحصول على رخصة المشغل من قبل الوالدين أو ولي الأمر عندما كان مقدم الطلب تحت أي سن؟",
                "16", "21", "18", 3, Question.STATE_OHIO);
        addQuestion(oQ2);
        Question oQ3 = new Question("ما هو أسلوب القيادة الأكثر أهمية لتجنب الحوادث أثناء القيادة في الظروف الجليدية أو الثلجية؟",
                "الاستمرار علي السرعة التي تقود بها", "تقليل السرعة وزيادة مسافة التلاحق", "زيادة السرعة وخفض مسافة التلاحق", 2, Question.STATE_OHIO);
        addQuestion(oQ3);
        Question oQ4 = new Question("إذا كنت تقود خلف حافلة المدرسة وكانت تستعمل ضوء أحمر يومض وإشارة قف يجب عليك",
                "أن تقف على الأقل على بعد 25 قدم", "أن تقف على الأقل على بعد 30 قدم", "أن تقف على الأقل على بعد 20 قدم", 1, Question.STATE_OHIO);
        addQuestion(oQ4);
        Question oQ5 = new Question("يجب دائما إحترام علامات التوقف أو الأضواء الساطعة عند معابر السكك الحديدية، لأن … ؟",
                "قد يتسبب في سحب رخصتك", "القطارات سريعة وثقيلة لا يمكن أن تتوقف بسرعة.", "قد تعرض نفسك لمخالفة قانونية", 2, Question.STATE_OHIO);
        addQuestion(oQ5);
        Question oQ6 = new Question("ما المسافة بالقدم التى يجب ان تبعد السيارة عندما تركنها فى الجهة المقابلة لمحطة الإطفاء؟",
                "70", "80", "75", 3, Question.STATE_OHIO);
        addQuestion(oQ6);
        Question oQ7 = new Question("ما هى الحالة الذهنية التي يتصف بها السائق الذى قاد السيارة لفترة طويلة أدى ذلك إلى حالة من فقدان الوعى اللحظى؟",
                "التنويم الإيحائي أو التنويم المغناطيسي", "الخمول الجسدي", "التنويم الذهني", 1, Question.STATE_OHIO);
        addQuestion(oQ7);
        Question oQ8 = new Question("للحصول على رخصة القيادة الأساسية يجب أن يكون عمر المراهق",
                "على الأقل 16 سنة", "على الأقل 20 سنة", "على الأقل 18 سنة", 3, Question.STATE_OHIO);
        addQuestion(oQ8);
        Question oQ9 = new Question("عند القيادة على طريق ثلجى بسرعة 30 ميل فى الساعة. كم تكون المسافة (بطول عدد السيارات ) بينك وبين السيارة التى تتبعها؟",
                "20", "18", "16", 2, Question.STATE_OHIO);
        addQuestion(oQ9);
        Question oQ10 = new Question("يمكن أن تركن السيارة بالتوازى مع الرصيف على بعد؟",
                "6 بوصات (إنش)", "8 بوصات (إنش)", "10 بوصات (إنش)", 1, Question.STATE_OHIO);
        addQuestion(oQ10);
        Question oQ11 = new Question("ماذا يمكن أن يحدث للشخص المضيف إذا ترك الضيف يغادر منزل الضيافة وهو في حالة سكر وتورط في حادثة؟",
                "دعوة قضائية", "سحب رخصته", "دفع غرامة", 1, Question.STATE_OHIO);
        addQuestion(oQ11);
        Question oQ12 = new Question("قاعدة 3 ثواني تنطبق على المساحة التي … سيارتك",
                "بجانب", "خلف", "أمام", 3, Question.STATE_OHIO);
        addQuestion(oQ12);
        Question oQ13 = new Question("لا تحتاج أن توقف سيارتك لشاحنة المثلجات الايس كريم عندما",
                "اذا كنت علي نفس الجانب في طريق سريع", "إذا كنت على الجانب الآخر فى طريق سريع مزدوج أو في وسطها.", "اذا كنت علي جانب موازي لها", 2, Question.STATE_OHIO);
        addQuestion(oQ13);
        Question oQ14 = new Question("ما هو الخطأ الشائع والذى يرتكبه السائقون الجدد؟",
                "الضغط على الفرامل بقوة", "النظر للخلف بكثرة", "استخدام الهاتف المحمول", 1, Question.STATE_OHIO);
        addQuestion(oQ14);
        Question oQ15 = new Question("في حالة لم تكن هناك علامة مخالفة لذلك. فإن الحد الأقصى للسرعة في منطقة المدرسة هي",
                "20 ميل في الساعة", "30 ميل في الساعة", "25 ميل في الساعة", 3, Question.STATE_OHIO);
        addQuestion(oQ15);
        Question oQ16 = new Question("ما هى المسافة التى يمكن ان تراها أمامك عند استعمال النور المنخفض؟",
                "300 قدم", "350 قدم", "250 قدم", 2, Question.STATE_OHIO);
        addQuestion(oQ16);
        Question oQ17 = new Question("عندما تركن سيارتك يجب ان تبتعد عن ممر الراجلين بـ … قدم",
                "25", "20", "30", 1, Question.STATE_OHIO);
        addQuestion(oQ17);
        Question oQ18 = new Question("عند القيادة بتصريح خاص.الطالب الذى عنده 16 سنة يجب ان يكون برفقته سائق أخر معه رخصة ويكون",
                "أكثر من 18 سنة ويكون ذو خبرة فى القيادة على الاقل 3 سنوات", "أكثر من 21 عام ويكون ذو خبرة فى القيادة على الاقل 3 سنوات", "أكثر من 24 عام ويكون ذو خبرة فى القيادة على الاقل 3 سنوات", 2, Question.STATE_OHIO);
        addQuestion(oQ18);
        Question oQ19 = new Question("كم يجب أن يكون عمرك لتحصل على تصريح خاص سارى كمتدرب؟",
                "16", "18", "21", 1, Question.STATE_OHIO);
        addQuestion(oQ19);
        Question oQ20 = new Question("ما هي المسافة المسموح بها لركن السيارة بالقرب من أماكن عبور السكك الحديد؟",
                "على الأقل 40 قدم", "على الأقل 50 قدم", "على الأقل 60 قدم", 2, Question.STATE_OHIO);
        addQuestion(oQ20);
        Question oQ21 = new Question("أنت كسائق متى يجب عليك ان توقف السيارة",
                "عندما توجد إشارة حمراء", "عندما يطلب منك شرطى الوقوف", "كل الخيارات صحيحة", 3, Question.STATE_OHIO);
        addQuestion(oQ21);
        Question oQ22 = new Question("عندما تقف حافلة المدرسة مباشرة أمام المدرسة لتنزيل أو أخذ الأطفال. يمكنك المرور على أى جانب من الحافلة بسرعة لا تزيد على؟",
                "20 ميل في الساعة", "10 ميل في الساعة", "30 ميل في الساعة", 2, Question.STATE_OHIO);
        addQuestion(oQ22);
        Question oQ23 = new Question("عند تركين عربتك. كم يجب ان تبتعد عن صنبور المطافىء؟",
                "10 اقدام", "5 اقدام", "15 اقدام", 1, Question.STATE_OHIO);
        addQuestion(oQ23);
        Question oQ24 = new Question("أفضل طريقة لتحديد مسافة التلاحق أو المسافة بين سيارتك والسيارة التي أمامك؟",
                "سؤال السائق في السيارة الآخري", "التحديد بالنظر", "قاعدة الـ 3 ثوانى", 3, Question.STATE_OHIO);
        addQuestion(oQ24);
        Question oQ25 = new Question("ماذا يسمى الممر (حارة المرور) المتجه إلى الطريق السريع والتى تزيد السرعة به؟",
                "حارة التسارع", "حارة المقابلة", "حارة التلاحق", 1, Question.STATE_OHIO);
        addQuestion(oQ25);
        Question oQ26 = new Question("إذا كان لابد من الإصطدام يجب عليك",
                "أن تختار الاصطدام بشيء سيعطيك طريق أفضل من شئ صلب", "أن تختار الاصطدام بشيء قائم افضل من شئ قادم فى اتجاهك", "كل الخيارات صحيحة", 3, Question.STATE_OHIO);
        addQuestion(oQ26);
        Question oQ27 = new Question("متى يكون سطح الطريق أكثر أنزلاقاً؟",
                "في الشتاء", "خلال الدقائق الأولى من نزول المطر", "في الصباح", 1, Question.STATE_OHIO);
        addQuestion(oQ27);
        Question oQ28 = new Question("ما هي انسب طريقة للاقتراب من منحنى على الطريق؟",
                "خفض السرعة قبل الدخول إلى المنحنى", "زود السرعة للمرور علي المنحني", "تسير علي سرعتك الحالية", 1, Question.STATE_OHIO);
        addQuestion(oQ28);
        Question oQ29 = new Question("ماذا يجب ان تفعل فى حالة وقوع حادثة؟",
                "أطلب الشرطة وأدلى بالمعلومات", "توقف وأطلب المساعدة", "كل الخيارات صحيحة", 3, Question.STATE_OHIO);
        addQuestion(oQ29);
        Question oQ30 = new Question("اذا انفجرت عجلة السيارة أثناء القيادة ماذا تفعل؟",
                "أبق داخل السيارة وانتظر المساعدة", "أترك السيارة تسير باستقامة للأمام و أبطئ قليلاً و بالتدريج أخرج من الطريق", "الإتصال بالشرطة طلبا للمساعدة", 2, Question.STATE_OHIO);
        addQuestion(oQ30);
        Question oQ31 = new Question("عند القيادة في الليل يجب القيادة بحرص تستطيع التوقف ضمن",
                "المساحة المضاءة أمامك بواسطة المصابيح الامامية", "أي مكان في المساحة التي أمامك", "المسافة التي بينك وبين السيارة بالخلف", 1, Question.STATE_OHIO);
        addQuestion(oQ31);
        Question oQ32 = new Question("ما هي المنطقة الموجودة خلف السيارة والتى لا يستطيع السائق أن يراها فى المرايات الجانبية؟",
                "النقطة المحجوبة", "النقطة السوداء", "النقطة العمياء", 3, Question.STATE_OHIO);
        addQuestion(oQ32);
        Question oQ33 = new Question("ماذا يعني الضوء الأصفر الوامض ؟",
                "تقدم بحذر", "توقف علي الفور", "اترك السيارة", 1, Question.STATE_OHIO);
        addQuestion(oQ33);
        Question oQ34 = new Question("خط أبيض متين على الحافة اليمنى في الطريق السريع في ميول نحو يسارك. وهذا يدل على أن",
                "أعمال بناء علي الطريق", "الطريق ستصبح متسعة", "الطريق ستصبح ضيقة", 3, Question.STATE_OHIO);
        addQuestion(oQ34);
        Question oQ35 = new Question("عند القيادة على طريق ثلجى بسرعة 30 ميل فى الساعة. كم تكون المسافة (بطول عدد السيارات ) بينك وبين السيارة التى تتبعها؟",
                "18", "16", "20", 1, Question.STATE_OHIO);
        addQuestion(oQ35);


        // QUESTIONS_STATE_PENNSYLVANIA
        Question pQ1 = new Question("ما هي المنطقة الموجودة خلف السيارة والتى لا يستطيع السائق أن يراها فى المرايات الجانبية؟",
                "النقطة العمياء", "النقطة السوداء", "النقطة المحجوبة", 1, Question.STATE_PENNSYLVANIA);
        addQuestion(pQ1);
        Question pQ2 = new Question("ترتيب الوان اشارة المرور معلقة من أعلى لأسفل",
                "الاحمر والاخضر والاصفر", "الاخضر والاصفر والاحمر", "الاحمر و الاصفر و الاخضر", 3, Question.STATE_PENNSYLVANIA);
        addQuestion(pQ2);
        Question pQ3 = new Question("عند القيادة على طريق ثلجى بسرعة 30 ميل فى الساعة. كم تكون المسافة (بطول عدد السيارات ) بينك وبين السيارة التى تتبعها؟",
                "20", "18", "16", 2, Question.STATE_PENNSYLVANIA);
        addQuestion(pQ3);
        Question pQ4 = new Question("الطالب الذي يقود سيارة ومعه تصريح خاص سارى كمتدرب وتحت اشراف معلم. ما هى الفترة الزمنية التى يمكن له أن ينتظرها ليحصل على رخصة قيادة مؤقتة ؟",
                "على الأقل 6 أشهر", "على الأقل 8 أشهر", "على الأقل 4 أشهر", 1, Question.STATE_PENNSYLVANIA);
        addQuestion(pQ4);
        Question pQ5 = new Question("عند القيادة على الطرق السريعة الرئيسية يجب ؟",
                "تبقي عينيك تتحركان.", "البقاء في حالة تأهب.", "كل الخيارات صحيحة", 3, Question.STATE_PENNSYLVANIA);
        addQuestion(pQ5);
        Question pQ6 = new Question("ماهي القيادة طبقا لقانون الولاية؟",
                "امتياز", "قانون", "مهارة", 1, Question.STATE_PENNSYLVANIA);
        addQuestion(pQ6);
        Question pQ7 = new Question("عندما تركن السيارة.المسافة التي يجب أن تترك بعيد عن علامة قف هي … قدم ؟",
                "40 قدم", "50 قدم", "30 قدم", 2, Question.STATE_PENNSYLVANIA);
        addQuestion(pQ7);
        Question pQ8 = new Question("كيف يمكن لشخص سكران ان يستعيد وعيه؟",
                "النوم", "شرب الماء", "الوقت", 3, Question.STATE_PENNSYLVANIA);
        addQuestion(pQ8);
        Question pQ9 = new Question("عدم ارتدائك لحزام الأمان في المقعد الأمامي. وعدم احكام حزام الامان للطفل تحت 18 عام يعتبر ؟",
                "مخالفة أساسية", "مخالفة ثانوي", "مخالفة عادية", 1, Question.STATE_PENNSYLVANIA);
        addQuestion(pQ9);
        Question pQ10 = new Question("عند القيادة بتصريح خاص.الطالب الذى عنده 16 سنة يجب ان يكون برفقته سائق أخر معه رخصة ويكون",
                "أكثر من 24 عام ويكون ذو خبرة فى القيادة على الاقل 3 سنوات", "أكثر من 21 عام ويكون ذو خبرة فى القيادة على الاقل 3 سنوات", "أكثر من 18 عام ويكون ذو خبرة فى القيادة على الاقل 3 سنوات", 2, Question.STATE_PENNSYLVANIA);
        addQuestion(pQ10);
        Question pQ11 = new Question("ماذا تفعل بعد القيادة خلال بركة من المياه؟",
                "أضغط بقوة على الفرامل لتختبرهم", "التأكد من سلامة عجلات السيارة", "التأكد من سلامة محتويات السيارة", 1, Question.STATE_PENNSYLVANIA);
        addQuestion(pQ11);
        Question pQ12 = new Question("كيف يمكن للسائق أن يتواصل مع السائقين الآخرين؟",
                "بإستخدام الهاتف المحمول", "بإستخدام اشارات اليدين", "الاضواء و بوق السيارة", 3, Question.STATE_PENNSYLVANIA);
        addQuestion(pQ12);
        Question pQ13 = new Question("متى يجب عليك إبلاغ إدارة المرور بعد وقوع حادثة؟",
                "يوم واحد", "10 أيام", "7 أيام", 2, Question.STATE_PENNSYLVANIA);
        addQuestion(pQ13);
        Question pQ14 = new Question("للقيادة في المدينة هناك تصرفات جيدة منها ؟",
                "عدم القيادة في المناطق المزدحمة", "عدم القيادة بسرعة عالية اثناء الليل", "أنظر على الأقل من 12 الى 15 ثانية على الطريق لترى ما هو أمامك", 3, Question.STATE_PENNSYLVANIA);
        addQuestion(pQ14);
        Question pQ15 = new Question("يجب دائما إحترام علامات التوقف أو الأضواء الساطعة عند معابر السكك الحديدية، لأن ؟",
                "القطارات سريعة وثقيلة ولكن أن تتوقف بسرعة.", "القطارات سريعة وثقيلة لا يمكن أن تتوقف بسرعة.", "القيادة خطره في هذه المنقطة", 2, Question.STATE_PENNSYLVANIA);
        addQuestion(pQ15);
        Question pQ16 = new Question("ماذا تعني علامة المرور ذي الثمانية أضلاع؟",
                "علامة قف", "خفف السرعة", "توجد أعمال بناء علي الطريق", 1, Question.STATE_PENNSYLVANIA);
        addQuestion(pQ16);
        Question pQ17 = new Question("متى يمكنك استعمال هاتفك المحمول أثناء القيادة؟",
                "في أي وقت تريد", "عندما تريد التحدث مع صديقك", "فى حالات الطوارئ مثل حادثة حريق او خطر على الطريق", 3, Question.STATE_PENNSYLVANIA);
        addQuestion(pQ17);
        Question pQ18 = new Question("ماذا تعني (هيدرو بلاننج) الإنزلاق فوق الماء؟",
                "توخي الحذر", "يفقد المطاط إطار السيارة ملامسة الطريق المبلل", "لا شئ مما سبق", 2, Question.STATE_PENNSYLVANIA);
        addQuestion(pQ18);
        Question pQ19 = new Question("سيتم معاقبة السائق الذي عمره أقل من 21 سنة عندما تصل نسبة الكحول فى الدم إلى؟",
                "0.01%", "0.02%", "0.03%", 1, Question.STATE_PENNSYLVANIA);
        addQuestion(pQ19);
        Question pQ20 = new Question("على أى الطرق يمكن أن توجد الخطوط المزدوجة الصلبة السميكة؟",
                "طريق سليم ذي اتجاهين", "طريق متعرج توجد عليه أعمال بناء", "طريق متعرج ذي اتجاهين", 3, Question.STATE_PENNSYLVANIA);
        addQuestion(pQ20);
        Question pQ21 = new Question("أفضل طريقة لتحديد مسافة التلاحق أو المسافة بين سيارتك والسيارة التي أمامك؟",
                "قاعدة الـ 3 ثوانى", "سؤال السائق في السيارة الآخري", "تحديدها بالنظر", 1, Question.STATE_PENNSYLVANIA);
        addQuestion(pQ21);
        Question pQ22 = new Question("عند القيادة مباشرة خلف شاحنة كبيرة. كيف يمكنك أن تحدد أنك غير موجود فى المنطقة العمياء للشاحنة؟",
                "عندما لا تستطيع رؤية الرصيف", "عندما لا تستطيع رؤية مرآة الشاحنة", "عندما لا تستطيع رؤية الشاحنة", 2, Question.STATE_PENNSYLVANIA);
        addQuestion(pQ22);
        Question pQ23 = new Question("(هيدرو بلاننج) الإنزلاق فوق الماء أكثر احتمالا حدوثه",
                "أثناء المطر الشديد", "اثناء الصبح", "في الشتاء", 1, Question.STATE_PENNSYLVANIA);
        addQuestion(pQ23);
        Question pQ24 = new Question("عندما تركن السيارة فى شارع منحدر لاسفل ويوجد رصيف على اليمين عجلات السيارة يجب أن تواجه؟",
                "سيارة آخري", "الطريق", "اتجاه الرصيف", 3, Question.STATE_PENNSYLVANIA);
        addQuestion(pQ24);
        Question pQ25 = new Question("من الممكن أن تقود السيارة فى الممتلكات العامة أو الخاصة وذلك لتجنب أشارة أو علامة للمرور",
                "عندما تكون حركة المرور خفيفة", "عندما يطلب منك ضابط البوليس أن تفعل ذلك.", "عندما تكون هناك حالة طوارئ", 2, Question.STATE_PENNSYLVANIA);
        addQuestion(pQ25);
        Question pQ26 = new Question("فى أى عمر يجب أن يستعمل الاطفال ﻤﻘﻌﺪ اﻷﻣﺎن اﻟﻤﺨﺼﺺ ﻟﻠﻄﻔﻞ فى الكرسى الخلفى للسيارة؟",
                "الأطفال تحت 6 سنوات و أقل من 60 باوند", "الأطفال تحت 10 سنوات و أقل من 100 باوند", "الأطفال تحت 8 سنوات و أقل من 80 باوند", 3, Question.STATE_PENNSYLVANIA);
        addQuestion(pQ26);
        Question pQ27 = new Question("لا تحتاج أن توقف سيارتك لشاحنة المثلجات الايس كريم عندما",
                "إذا كنت على الجانب الآخر فى طريق سريع مزدوج أو في وسطها.", "اذا كانت علي الجانب الموازي لك", "اذا كانت علي نفس الجانب", 1, Question.STATE_PENNSYLVANIA);
        addQuestion(pQ27);
        Question pQ28 = new Question("قاعدة 3 ثواني تنطبق على المساحة التي … سيارتك",
                "بجانب", "أمام", "خلف", 2, Question.STATE_PENNSYLVANIA);
        addQuestion(pQ28);
        Question pQ29 = new Question("مثلت احمر وأبيض في التقاطع يعني ؟",
                "توجد تعرجات أمامك", "وقف السيارة علي الفور", "خفف السير وكن مستعدا للوقوف اذا كان ضروري", 3, Question.STATE_PENNSYLVANIA);
        addQuestion(pQ29);
        Question pQ30 = new Question("لماذا لا تستطيع قطع الخط المتقطع الابيض او الاصفر؟",
                "يمكن أن تتداخل مع حركة المرور عند القيام بذلك", "قد يعرضك لسحب الرخصة", "من الممكن التسبب في حادثة", 1, Question.STATE_PENNSYLVANIA);
        addQuestion(pQ30);
        Question pQ31 = new Question("علامة ممنوع التركين “NO Parking” في بعض الأماكن تعني",
                "غير مسموح بالمرور من هنا", "لا يمكنك الوقوف هنا", "يمكن أن تقف لحمل أو انزال الركاب", 3, Question.STATE_PENNSYLVANIA);
        addQuestion(pQ31);
        Question pQ32 = new Question("ما هى المسافة التى يمكن ان تراها أمامك عند استعمال النور المنخفض؟",
                "350 قدم", "300 قدم", "250 قدم", 1, Question.STATE_PENNSYLVANIA);
        addQuestion(pQ32);
        Question pQ33 = new Question("متى تحدث الكثير من الحوادث عند التقاطعات؟",
                "اثناء الإزدحام المروري", "فى أول ثواني بعد تغيير أضواء إشارات المرور", "اثناء الليل", 2, Question.STATE_PENNSYLVANIA);
        addQuestion(pQ33);
        Question pQ34 = new Question("متى يمكنك استعمال هاتفك المحمول أثناء القيادة؟",
                "عندما تريد التحدث مع صديقك", "فى حالات الطوارئ مثل حادثة حريق او خطر على الطريق", "عندما تريد تصفح الإنترنت", 2, Question.STATE_PENNSYLVANIA);
        addQuestion(pQ34);
        Question pQ35 = new Question("للحصول على رخصة القيادة الأساسية يجب أن يكون عمر المراهق",
                "على الأقل 18 سنة", "على الأقل 21 سنة", "على الأقل 16 سنة", 1, Question.STATE_PENNSYLVANIA);
        addQuestion(pQ35);


        // QUESTIONS_STATE_TEXAS
        Question tQ1 = new Question("ما هو الحد الأدنى للسن الذي يمكنك فيه الحصول على رخصة قيادة من الفئة C بدون حصص تعليم السائق أو أن تكون في حالة شاقة؟",
                "21 سنة", "18 سنة", "16 سنة", 2, Question.STATE_TEXAS);
        addQuestion(tQ1);
        Question tQ2 = new Question("اذا قمت ببيع الكحول الى قاصر في تكساس فمن الممكن ان",
                "السجن لمدة 1 سنة بدون دفع غرامة مالية", "السجن لمدة 3 سنوات مع غرامة مالية 400 دولار", "تواجه غرامة مالية تصل الى 4000 دولار و/او السجن الى غاية سنة.", 3, Question.STATE_TEXAS);
        addQuestion(tQ2);
        Question tQ3 = new Question("مخالفة القيادة لاول مرة بدون رخصة القيادة في ولاية تكساس تصل عقوبتها الى",
                "200 دولار", "250 دولار", "150 دولار", 1, Question.STATE_TEXAS);
        addQuestion(tQ3);
        Question tQ4 = new Question("ما هى المسافة التى يمكن ان تراها أمامك عند استعمال النور المنخفض؟",
                "300 قدم", "350 قدم", "250 قدم", 2, Question.STATE_TEXAS);
        addQuestion(tQ4);
        Question tQ5 = new Question("متى تحدث الكثير من الحوادث عند التقاطعات؟",
                "عند ازدحام حركة المرور", "اثناء الليل", "فى أول ثواني بعد تغيير أضواء إشارات المرور", 3, Question.STATE_TEXAS);
        addQuestion(tQ5);
        Question tQ6 = new Question("عند القيادة في الليل يجب القيادة بحرص تستطيع التوقف ضمن",
                "المساحة المضاءة أمامك بواسطة المصابيح الامامية", "المساحة الفارغة التي أمامك", "المكان الذي قمت بتحديده", 1, Question.STATE_TEXAS);
        addQuestion(tQ6);
        Question tQ7 = new Question("يمكن أن تركن السيارة بالتوازى مع الرصيف على بعد؟",
                "4 بوصات (إنش)", "6 بوصات (إنش)", "8 بوصات (إنش)", 2, Question.STATE_TEXAS);
        addQuestion(tQ7);
        Question tQ8 = new Question("اذا كنت تقود سيارة بسرعة 50 ميل فى الساعة ما هي مسافة التوقف التي ستحتاجها لإيقاف السيارة وقوفا تاما",
                "247 قدم", "147 قدم", "347 قدم", 1, Question.STATE_TEXAS);
        addQuestion(tQ8);
        Question tQ9 = new Question("الطالب الذي يقود سيارة ومعه تصريح خاص سارى كمتدرب وتحت اشراف معلم. ما هى الفترة الزمنية التى يمكن له أن ينتظرها ليحصل على رخصة قيادة مؤقتة ؟",
                "على الأقل 4 أشهر", "على الأقل 8 أشهر", "على الأقل 6 أشهر", 3, Question.STATE_TEXAS);
        addQuestion(tQ9);
        Question tQ10 = new Question("ما المسافة بالقدم التى يجب ان تبعد السيارة عندما تركنها فى الجهة المقابلة لمحطة الإطفاء؟",
                "75", "80", "70", 1, Question.STATE_TEXAS);
        addQuestion(tQ10);
        Question tQ11 = new Question("ما هى المسافة التى يمكن ان تراها أمامك عند استعمال النور العالى؟",
                "600 قدم", "500 قدم", "400 قدم", 2, Question.STATE_TEXAS);
        addQuestion(tQ11);
        Question tQ12 = new Question("عند تركين عربتك.كم يجب ان تبتعد عن صنبور المطافىء؟",
                "30 قدم", "20 قدم", "10 اقدام", 3, Question.STATE_TEXAS);
        addQuestion(tQ12);
        Question tQ13 = new Question("عند القيادة على طريق مبلل بالمياه بسرعة 40 ميل فى الساعة. كم تكون المسافة (بطول عدد السيارات ) بينك وبين السيارة التى تتبعها؟",
                "10", "8", "6", 2, Question.STATE_TEXAS);
        addQuestion(tQ13);
        Question tQ14 = new Question("من هو المعتاد على المخالفة؟",
                "أى شخص تم إيقاف رخصته ثلاث مرات خلال ثلاث اعوام", "أى شخص تم إيقاف رخصته خمس مرات خلال ثلاث اعوام", "أى شخص تم إيقاف رخصته أربع مرات خلال ثلاث اعوام", 1, Question.STATE_TEXAS);
        addQuestion(tQ14);
        Question tQ15 = new Question("عند القيادة على طريق ثلجى بسرعة 30 ميل فى الساعة. كم تكون المسافة (بطول عدد السيارات ) بينك وبين السيارة التى تتبعها؟",
                "20", "16", "18", 3, Question.STATE_TEXAS);
        addQuestion(tQ15);
        Question tQ16 = new Question("إذا تعطلت السيارة على الطريق السريع أول شئ يجب ان تفعله هو؟",
                "حاول أن تخرج من الطريق", "اتصل بالشرطة", "اتصل بصديقك", 1, Question.STATE_TEXAS);
        addQuestion(tQ16);
        Question tQ17 = new Question("ما هى الحالة الذهنية التي يتصف بها السائق الذى قاد السيارة لفترة طويلة أدى ذلك إلى حالة من فقدان الوعى اللحظى؟",
                "التنويم الذهني", "التنويم الإيحائي أو التنويم المغناطيسي", "الخمول الجسدي", 2, Question.STATE_TEXAS);
        addQuestion(tQ17);
        Question tQ18 = new Question("إذا كنت تقود خلف حافلة المدرسة وكانت تستعمل ضوء أحمر يومض وإشارة قف يجب عليك",
                "أن تقف على الأقل على بعد 20 قدم", "أن تقف على الأقل على بعد 25 قدم", "أن تقف على الأقل على بعد 30 قدم", 2, Question.STATE_TEXAS);
        addQuestion(tQ18);
        Question tQ19 = new Question("سيتم معاقبة السائق الذي عمره أقل من 21 سنة عندما تصل نسبة الكحول فى الدم إلى؟",
                "0.01%", "0.02%", "0.03%", 1, Question.STATE_TEXAS);
        addQuestion(tQ19);
        Question tQ20 = new Question("للحصول على رخصة القيادة الأساسية يجب أن يكون عمر المراهق",
                "على الأقل 18 سنة", "على الأقل 16 سنة", "على الأقل 20 سنة", 1, Question.STATE_TEXAS);
        addQuestion(tQ20);
        Question tQ21 = new Question("متى يجب على السائق أن يستعمل الأنوار الأمامية العالية؟",
                "فترة القيادة اثناء الليل", "خلال القيادة في الأراضي المكشوفة وعلى الطرق السريعة خافتة الأضاءة", "خلال القيادة اثناء الليل علي الطرق المتعرجة", 2, Question.STATE_TEXAS);
        addQuestion(tQ21);
        Question tQ22 = new Question("عدم ارتدائك لحزام الأمان في المقعد الأمامي. وعدم احكام حزام الامان للطفل تحت 18 عام يعتبر…؟",
                "مخالفة عادية", "مخالفة ثانوي", "مخالفة أساسية", 3, Question.STATE_TEXAS);
        addQuestion(tQ22);
        Question tQ23 = new Question("ماذا يجب ان تفعل فى حالة وقوع حادثة؟",
                "توقف وأطلب المساعدة", "أطلب الشرطة وأدلى بالمعلومات", "كل الخيارات صحيحة", 3, Question.STATE_TEXAS);
        addQuestion(tQ23);
        Question tQ24 = new Question("على أى الطرق يمكن أن توجد الخطوط المزدوجة الصلبة السميكة؟",
                "طريق متعرج ذو اتجاه واحد", "طريق متعرج ذي اتجاهين", "طريق سليم ذي اتجاهين", 3, Question.STATE_TEXAS);
        addQuestion(tQ24);
        Question tQ25 = new Question("عندما تقف حافلة المدرسة مباشرة أمام المدرسة لتنزيل أو أخذ الأطفال. يمكنك المرور على أى جانب من الحافلة بسرعة لا تزيد على؟",
                "10 ميل في الساعة", "5 ميل في الساعة", "15 ميل في الساعة", 1, Question.STATE_TEXAS);
        addQuestion(tQ25);
        Question tQ26 = new Question("لماذا يجب على السائق أن يحضر برنامج إدارة المرور لتحسين القيادة؟",
                "لتعلم القيادة", "لتحسين مهاراته", "بسبب نظام النقاط", 3, Question.STATE_TEXAS);
        addQuestion(tQ26);
        Question tQ27 = new Question("ماذا تعني علامة المربع وبداخله دائرة حمراء؟",
                "ممنوع الدخول", "قف", "خفف السرعة", 1, Question.STATE_TEXAS);
        addQuestion(tQ27);
        Question tQ28 = new Question("(هيدرو بلاننج) الإنزلاق فوق الماء أكثر احتمالا حدوثه",
                "اثناء الصباح", "أثناء المطر الشديد", "اثناء الليل", 2, Question.STATE_TEXAS);
        addQuestion(tQ28);
        Question tQ29 = new Question("كيف يمكن لشخص سكران ان يستعيد وعيه؟",
                "النوم", "شرب الماء", "الوقت", 3, Question.STATE_TEXAS);
        addQuestion(tQ29);
        Question tQ30 = new Question("سيتم معاقبة السائق الذي عمره أقل من 21 سنة عندما تصل نسبة الكحول فى الدم إلى؟",
                "0.01%", "0.02%", "0.03%", 1, Question.STATE_TEXAS);
        addQuestion(tQ30);
        Question tQ31 = new Question("متى يجب على السائق أن يستعمل الأنوار الأمامية العالية؟",
                "عند مقابلة سيارة اخري", "خلال القيادة في الأراضي المكشوفة وعلى الطرق السريعة خافتة الأضاءة", "خلال القيادة علي طريق متعرج", 2, Question.STATE_TEXAS);
        addQuestion(tQ31);
        Question tQ32 = new Question("لو تم ضبط الراكب (18 سنة واكثر) فى المقعد الامامى لا يرتدى حزام الامان من المسؤول؟",
                "السائق فقط", "الراكب والسائق معا", "الراكب فقط", 3, Question.STATE_TEXAS);
        addQuestion(tQ32);
        Question tQ33 = new Question("يجب تشغيل المصابيح الأمامية الخاصة بك:",
                "نصف ساعة قبل شروق الشمس", "نصف ساعة بعد غروب الشمس", "كل الخيارات صحيحة", 3, Question.STATE_TEXAS);
        addQuestion(tQ33);
        Question tQ34 = new Question("عند القيادة على طريق ثلجى بسرعة 30 ميل فى الساعة. كم تكون المسافة (بطول عدد السيارات) بينك وبين السيارة التى تتبعها؟",
                "10", "6", "8", 3, Question.STATE_TEXAS);
        addQuestion(tQ34);
        Question tQ35 = new Question("للقيادة في المدينة هناك تصرفات جيدة منها …؟",
                "أنظر على الأقل من 12 الى 15 ثانية على الطريق لترى ما هو أمامك", "إعطاء الأولوية لسيارات الشرطة", "عدم القيادة بسرعة في منطقة مدرسة", 1, Question.STATE_TEXAS);
        addQuestion(tQ35);
        Question tQ36 = new Question("على أى الطرق يمكن أن توجد الخطوط المزدوجة الصلبة السميكة؟",
                "طريق سليم ذي اتجاهين", "طريق متعرج ذي اتجاهين", "طريق سسليم ذو اتجاه واحد", 2, Question.STATE_TEXAS);
        addQuestion(tQ36);
        Question tQ37 = new Question("عندما تركن سيارتك يجب ان تبتعد عن ممر الراجلين بـ … قدم",
                "25", "30", "20", 1, Question.STATE_TEXAS);
        addQuestion(tQ37);
        Question tQ38 = new Question("متى يمكنك استعمال هاتفك المحمول أثناء القيادة؟",
                "عندما تريد تسصفح الإنترنت", "عندما تريد التحدث مع صديقك", "فى حالات الطوارئ مثل حادثة حريق او خطر على الطريق", 3, Question.STATE_TEXAS);
        addQuestion(tQ38);
        Question tQ39 = new Question("من الممكن أن تقود السيارة فى الممتلكات العامة أو الخاصة وذلك لتجنب أشارة أو علامة للمرور",
                "اذا كان الوضع يسمح لك بالدخول", "عندما يطلب منك ضابط البوليس أن تفعل ذلك.", "اذا كان معك رخصة", 2, Question.STATE_TEXAS);
        addQuestion(tQ39);
        Question tQ40 = new Question("أفضل طريقة لتحديد مسافة التلاحق أو المسافة بين سيارتك والسيارة التي أمامك؟",
                "قاعدة الـ 3 ثوانى", "تحديدها بالنظر", "سؤال السائق في السيارة الآخري", 1, Question.STATE_TEXAS);
        addQuestion(tQ40);
        Question tQ41 = new Question("ما هي المسافة المسموح بها لركن السيارة بالقرب من أماكن عبور السكك الحديد؟",
                "على الأقل 60 قدم", "على الأقل 40 قدم", "على الأقل 50 قدم", 3, Question.STATE_TEXAS);
        addQuestion(tQ41);
        Question tQ42 = new Question("اذا كنت تقود سيارة بسرعة 50 ميل فى الساعة ما هي مسافة التوقف التي ستحتاجها لإيقاف السيارة وقوفا تاما",
                "247 قدم", "147 قدم", "347 قدم", 1, Question.STATE_TEXAS);
        addQuestion(tQ42);
        Question tQ43 = new Question("فى حالة تعطل إشارات الانعطاف عن العمل. ما هي أفضل طريقة تشير بأنك ستدير السيارة؟",
                "عن طريق الهاتف المحمول", "عن طريق التحدث", "أستعمل إشارات اليد", 3, Question.STATE_TEXAS);
        addQuestion(tQ43);
        Question tQ44 = new Question("فى أى عمر يجب أن يستعمل الاطفال ﻤﻘﻌﺪ اﻷﻣﺎن اﻟﻤﺨﺼﺺ ﻟﻠﻄﻔﻞ فى الكرسى الخلفى للسيارة؟",
                "الأطفال تحت 7 سنوات و أقل من 70 باوند", "الأطفال تحت 8 سنوات و أقل من 80 باوند", "الأطفال تحت 10 سنوات و أقل من 100 باوند", 2, Question.STATE_TEXAS);
        addQuestion(tQ44);
        Question tQ45 = new Question("لو تم ضبط راكب فى المقعد الامامى عمرة 17 سنة لا يرتدي حزام الأمان على من تكون المسؤولية؟",
                "السائق فقط", "الراكب فقط", "الراكب والسائق معا", 1, Question.STATE_TEXAS);
        addQuestion(tQ45);
        Question tQ46 = new Question("إذا مساحات الزجاج الأمامي الواقي توقفت فجأة أثناء المطر أو الثلج يجب عليك",
                "دحرج ( انزل) النافذة الجانبية للسائق وأخرٍجْ رأسك حتى تتمكن من الرؤية", "دوس الفرامل واسحب السيارة لجانب الطريق.", "كل الخيارات صحيحة", 3, Question.STATE_TEXAS);
        addQuestion(tQ46);
        Question tQ47 = new Question("لا تحتاج أن توقف سيارتك لشاحنة المثلجات الايس كريم عندما",
                "اذا كنت علي الجانب الموازي علي طريق سريع مزدوج", "إذا كنت على الجانب الآخر فى طريق سريع مزدوج أو في وسطها.", "اذا كنت علي نفس الجانب في طريق سريع مزدوج", 2, Question.STATE_TEXAS);
        addQuestion(tQ47);
        Question tQ48 = new Question("ما التي تستعمل في الطرق السريعة لتوجيه السائقين نحو المسار الصحيح لانعطاف",
                "سهم اسود وسط المسارات أو الحارات", "سهم احمر وسط المسارات أو الحارات", "سهم ابيض وسط المسارات أو الحارات", 3, Question.STATE_TEXAS);
        addQuestion(tQ48);
        Question tQ49 = new Question("لماذا لا تستطيع قطع الخط المتقطع الابيض او الاصفر؟",
                "يمكن أن تتداخل مع حركة المرور عند القيام بذلك", "قد تتسبب في حادث", "لا يوجد معك ترخيص", 1, Question.STATE_TEXAS);
        addQuestion(tQ49);
        Question tQ50 = new Question("شرب القهوة بعد شرب الكحول",
                "يلغي مفهول الكحول علي الفور", "ليس له تأثير على محتوى الكحول في الدم.", "له تأثير ولكن خفيف يحتاج لبعض الوقت", 2, Question.STATE_TEXAS);
        addQuestion(tQ50);


        // QUESTIONS_STATE_FLORIDA
        Question fQ1 = new Question("أفضل طريقة للتحدث مع السائقين الآخرين هي",
                "استخدام الهاتف المحمول", "استخدام اشارات اليد", "استخدام بوق سيارتك أو الأضواء", 3, Question.STATE_FLORIDA);
        addQuestion(fQ1);
        Question fQ2 = new Question("عند القيادة على طريق ثلجى بسرعة 30 ميل فى الساعة. كم تكون المسافة (بطول عدد السيارات ) بينك وبين السيارة التى تتبعها؟",
                "18", "16", "14", 1, Question.STATE_FLORIDA);
        addQuestion(fQ2);
        Question fQ3 = new Question("عند القيادة مباشرة خلف شاحنة كبيرة. كيف يمكنك أن تحدد أنك غير موجود فى المنطقة العمياء للشاحنة؟",
                "عندما لا تستطيع رؤية الشاحنة", "عندما لا تستطيع رؤية مرآة الشاحنة", "عندما لا تستطيع رؤية الرصيف", 2, Question.STATE_FLORIDA);
        addQuestion(fQ3);
        Question fQ4 = new Question("عندما تركن السيارة فى شارع منحدر لاسفل ويوجد رصيف على اليمين عجلات السيارة يجب أن تواجه؟",
                "اتجاه السيارة المجاورة", "اتجاه الطريق", "اتجاه الرصيف", 3, Question.STATE_FLORIDA);
        addQuestion(fQ4);
        Question fQ5 = new Question("اذا كنت تقود سيارة بسرعة 50 ميل فى الساعة ما هي مسافة التوقف التي ستحتاجها لإيقاف السيارة وقوفا تاما",
                "247 قدم", "147 قدم", "347 قدم", 1, Question.STATE_FLORIDA);
        addQuestion(fQ5);
        Question fQ6 = new Question("للقيادة في المدينة هناك تصرفات جيدة منها …؟",
                "لا تقود بجانب منطقة مدرسة", "أنظر على الأقل من 12 الى 15 ثانية على الطريق لترى ما هو أمامك", "لا تقود بسرعة عالية اثناء الليل", 2, Question.STATE_FLORIDA);
        addQuestion(fQ6);
        Question fQ7 = new Question("عند القيادة على طريق مبلل بالمياه بسرعة 40 ميل فى الساعة. كم تكون المسافة (بطول عدد السيارات ) بينك وبين السيارة التى تتبعها؟",
                "8", "10", "6", 1, Question.STATE_FLORIDA);
        addQuestion(fQ7);
        Question fQ8 = new Question("أفضل طريقة لتحديد مسافة التلاحق أو المسافة بين سيارتك والسيارة التي أمامك؟",
                "سؤال السائق في السيارة الآخري", "قاعدة الـ 3 ثوانى", "تحديدها بالنظر", 2, Question.STATE_FLORIDA);
        addQuestion(fQ8);
        Question fQ9 = new Question("متى يجب على السائق أن يستعمل الأنوار الأمامية العالية؟",
                "خلال القيادة في الأراضي المكشوفة وعلى الطرق السريعة خافتة الأضاءة", "عند القيادة علي طرق سريعة واسعة", "خلال القيادة علي طريق متعرج", 1, Question.STATE_FLORIDA);
        addQuestion(fQ9);
        Question fQ10 = new Question("ماهي القيادة طبقا لقانون الولاية؟",
                "خبرة", "مهارة", "امتياز", 3, Question.STATE_FLORIDA);
        addQuestion(fQ10);
        Question fQ11 = new Question("استخدام كلأ من أحزمة الأمان وأحزمة الكتف هى مهمة لأنها",
                "تحافظ علي محتويات السيارة", "زيادة من فرصك فى البقاء على قيد الحياة", "تساعدك في اجتياز الطرق", 2, Question.STATE_FLORIDA);
        addQuestion(fQ11);
        Question fQ12 = new Question("عند القيادة على الطرق السريعة الرئيسية يجب ؟",
                "تبقي عينيك تتحركان.", "البقاء في حالة تأهب.", "كل الخيارات صحيحة", 3, Question.STATE_FLORIDA);
        addQuestion(fQ12);
        Question fQ13 = new Question("كل السائقين يجب أن يقودوا ببطئ عند الاقتراب من",
                "التقاطعات", "المنخفضات", "كل الخيارات صحيحة", 3, Question.STATE_FLORIDA);
        addQuestion(fQ13);
        Question fQ14 = new Question("لا تحتاج أن توقف سيارتك لشاحنة المثلجات الايس كريم عندما",
                "إذا كنت على الجانب الآخر فى طريق سريع مزدوج أو في وسطها.", "اذا كنت علي نفس الجانب في طريق سريع", "اذا كنت علي الجانب الموازي في طريق سريع", 1, Question.STATE_FLORIDA);
        addQuestion(fQ14);
        Question fQ15 = new Question("عدم ارتدائك لحزام الأمان في المقعد الأمامي. وعدم احكام حزام الامان للطفل تحت 18 عام يعتبر…؟",
                "مخالفة عادية", "مخالفة أساسية", "مخالفة ثانوي", 2, Question.STATE_FLORIDA);
        addQuestion(fQ15);
        Question fQ16 = new Question("لو تم ضبط الراكب (18 سنة واكثر) فى المقعد الامامى لا يرتدى حزام الامان من المسؤول؟",
                "الراكب فقط", "السائق فقط", "الراكب والسائق فقط", 1, Question.STATE_FLORIDA);
        addQuestion(fQ16);
        Question fQ17 = new Question("الطالب الذي يقود سيارة ومعه تصريح خاص سارى كمتدرب وتحت اشراف معلم. ما هى الفترة الزمنية التى يمكن له أن ينتظرها ليحصل على رخصة قيادة مؤقتة ؟",
                "على الأقل 5 أشهر", "على الأقل 4 أشهر", "على الأقل 6 أشهر", 3, Question.STATE_FLORIDA);
        addQuestion(fQ17);
        Question fQ18 = new Question("من هو المعتاد على المخالفة؟",
                "أى شخص تم إيقاف رخصته خمس مرات خلال ثلاث اعوام", "أى شخص تم إيقاف رخصته أربع مرات خلال ثلاث اعوام", "أى شخص تم إيقاف رخصته ثلاث مرات خلال ثلاث اعوام", 3, Question.STATE_FLORIDA);
        addQuestion(fQ18);
        Question fQ19 = new Question("عند القيادة في الاجواء السيئة يجب؟",
                "زيادة قاعدة (الثانيتين)", "بطء السرعة", "النظر للخلف بكثرة", 1, Question.STATE_FLORIDA);
        addQuestion(fQ19);
        Question fQ20 = new Question("لو أنت سائق معك تصريح خاص سارى كمتدرب",
                "لا يجوز لك استخدام الهواتف المحمولة أو غيرها من الأجهزة الإلكترونية المحمولة", "لا تستطيع القيادة بين الساعة 11:01 مساء والساعة 5:00 صباحا", "كل الاجابات صحيحة", 3, Question.STATE_FLORIDA);
        addQuestion(fQ20);
        Question fQ21 = new Question("قاعدة 3 ثوانى تشير إلى",
                "مسافة المقابلة", "مسافة التلاحق (المسافة التي ينبغي ان تترك اماك خلف سيارة اخرى)", "مسافة القانون", 2, Question.STATE_FLORIDA);
        addQuestion(fQ21);
        Question fQ22 = new Question("ما هى الاختبارات المطلوبة من الطالب ليمارس القيادة؟",
                "اختبار المعرفة و اختبار النظر", "اختبار الذهن", "اختبار الظهر", 1, Question.STATE_FLORIDA);
        addQuestion(fQ22);
        Question fQ23 = new Question("ما هو الخطأ الشائع والذى يرتكبه السائقون الجدد؟",
                "النظر للخلف بكثرة", "الضغط على الفرامل بقوة", "استخدام الهاتف المحمول", 2, Question.STATE_FLORIDA);
        addQuestion(fQ23);
        Question fQ24 = new Question("يجب دائما إحترام علامات التوقف أو الأضواء الساطعة عند معابر السكك الحديدية،لأن…؟",
                "قد يتم سحب الرخصة الخاصة بك", "القطارات سريعة وثقيلة ولكن يمكن أن تتوقف بسرعة.", "القطارات سريعة وثقيلة لا يمكن أن تتوقف بسرعة.", 3, Question.STATE_FLORIDA);
        addQuestion(fQ24);
        Question fQ25 = new Question("فى حالة تعطل إشارات الانعطاف عن العمل. ما هي أفضل طريقة تشير بأنك ستدير السيارة؟",
                "أستعمل إشارات اليد", "استخدام الهاتف المحمول", "التحدث", 1, Question.STATE_FLORIDA);
        addQuestion(fQ25);
        Question fQ26 = new Question("أثناء قيادة السيارة ما هى الاشياء الثلاث التى يجب ان تكون دائما معك؟",
                "إسعافات أولية، رخصة السيارة، الكثير من المال", "زجاجة مياه، رخصة السيارة، جهاز لاسلكي", "رخصة أو تصريح القيادة، وتسجيل السيارة، و بطاقة التأمين", 3, Question.STATE_FLORIDA);
        addQuestion(fQ26);
        Question fQ27 = new Question("متى تحدث الكثير من الحوادث عند التقاطعات؟",
                "عندما تكون حركة المرور مزدحمة", "فى أول ثواني بعد تغيير أضواء إشارات المرور", "اثناء الليل", 2, Question.STATE_FLORIDA);
        addQuestion(fQ27);
        Question fQ28 = new Question("ماذا يجب ان تفعل فى حالة وقوع حادثة؟",
                "أطلب الشرطة وأدلى بالمعلومات", "توقف وأطلب المساعدة", "كل الخيارات صحيحة", 3, Question.STATE_FLORIDA);
        addQuestion(fQ28);
        Question fQ29 = new Question("علامة تحديد السرعة هي من أجل ؟",
                "تخبرك بأن تخفف السرعة", "تنبيهك لوجود أعمال بناء بالأمام", "الحفاظ على سير حركة المرور بسلاسة", 3, Question.STATE_FLORIDA);
        addQuestion(fQ29);
        Question fQ30 = new Question("ماذا يعني الاصفر الوامض في اشارة الاضواء الثلاثة؟",
                "تقدم بحذر", "توقف", "الطريق به أعمال بناء", 1, Question.STATE_FLORIDA);
        addQuestion(fQ30);
        Question fQ31 = new Question("علامة لا توقف \"No standing\" في بعض الأماكن تعني",
                "لا يمكنك المرور من هنا", "يمكن الوقوف مؤقتا لحمل او تنزيل الركاب", "لا يمكنك الوقوف هنا", 2, Question.STATE_FLORIDA);
        addQuestion(fQ31);
        Question fQ32 = new Question("لماذا لا تستطيع قطع الخط المتقطع الابيض او الاصفر؟",
                "يمكن أن تتداخل مع حركة المرور عند القيام بذلك", "تحتاج الي ترخيص", "قد يتسبب ذلك في حادث", 1, Question.STATE_FLORIDA);
        addQuestion(fQ32);
        Question fQ33 = new Question("يمكن أن تتجاوز عربة اخرى من اليمين في حالة",
                "إذا كانت سرعتها أقل من سرعتك", "إذا كانت تريد ان تنعطف يسارا", "إذا كانت تريد ان تنعطف يمينا", 3, Question.STATE_FLORIDA);
        addQuestion(fQ33);
        Question fQ34 = new Question("شرب القهوة بعد شرب الكحول",
                "ليس له تأثير على محتوى الكحول في الدم.", "له تأثير قوي ويلغي مفعول الكحول", "له تأثير خفيف ويحتاج بعض الوقت", 1, Question.STATE_FLORIDA);
        addQuestion(fQ34);
        Question fQ35 = new Question("ما هي الطريقة الوحيدة الفعالة لتقليل نسبة الكحول في الدم (BAC)؟",
                "شرب الماء", "اسمح بعض الوقت لجسمك حتى يقل او ينعدم تاثير الكحول", "النوم", 2, Question.STATE_FLORIDA);
        addQuestion(fQ35);


        // QUESTION_STATE_CALIFORNIA
        Question cQ1 = new Question("خلال الأشهر الـ 12 الأولى بعد الحصول على رخصتك ، يجب أن تكون برفقة الوالدين أو الوصي إذا كنت:",
                "تقود في طريق مزحم جدا", "تنقل أطفالا في سيارتك ما بين الساعة 11 ليلا و 5 صباحا", "تقود علي طريق سريع اثناء الليل", 2, Question.STATE_CALIFORNIA);
        addQuestion(cQ1);
        Question cQ2 = new Question("أنت تسير في شارع باتجاه واحد. قد انعطف لليسار إلى شارع آخر باتجاه واحد إلا إذا:",
                "حركة المرور في الشارع تتحرك إلى اليسار.", "حركة المرور في الشارع تتحرك إلى اليمين.", "حركة المرور في الشارع خفيفة.", 1, Question.STATE_CALIFORNIA);
        addQuestion(cQ2);
        Question cQ3 = new Question("اذا كان لديك رخصة القيادة لمدة 3 اشهر",
                "القيادة في أي وقت", "القيادة ما بين 5 مساءا و 11 مساءا بدون مراقبة", "القيادة ما بين 5 صباحا و 11 مساءا بدون مراقبة", 3, Question.STATE_CALIFORNIA);
        addQuestion(cQ3);
        Question cQ4 = new Question("عندما تقوم بالدخول الى الطريق السريع، يجب أن تكون السرعة:",
                "مثل أو أقرب من سرعة حركة المرور على الطريق السريع.", "أعلي من سرعة حركة المرور على الطريق السريع.", "لا تساوي سرعة حركة المرور على الطريق السريع.", 1, Question.STATE_CALIFORNIA);
        addQuestion(cQ4);
        Question cQ5 = new Question("دائما راقب بحدر شديد الدراجات النارية عندما تريد تغيير الحارات لان…؟",
                "ذلك مخالف للقانون", "من الصعب رؤية احجامهم الصغيرة", "الأولوية لهم في الطريق", 2, Question.STATE_CALIFORNIA);
        addQuestion(cQ5);
        Question cQ6 = new Question("عند القيادة في الضباب يجب استعمال ضوء",
                "الأشعة المنخفضة", "الأشعة العالية", "الأشعة المتوسطة", 1, Question.STATE_CALIFORNIA);
        addQuestion(cQ6);
        Question cQ7 = new Question("إذا كنت تقترب من منحنى أو أعلى تل ولم يكن لديك رؤية واضحة للطريق إلى الأمام، يجب عليك:",
                "اوقف السيارة حتي تتضح الرؤية", "خفف السير حتى تستطيع الوقوف إن كان ضروري", "قم بزيادة السرعة أقصي من يمكن", 2, Question.STATE_CALIFORNIA);
        addQuestion(cQ7);
        Question cQ8 = new Question("يجب مراقبة المرايا الرؤية الخلفية",
                "عند الإنعطافات فقط", "من ساعة لآخري حتي تراق الحركة من خلفك", "باستمرار حتى تراقب تحركات السيارات خلفك", 3, Question.STATE_CALIFORNIA);
        addQuestion(cQ8);
        Question cQ9 = new Question("في هذه الولاية ما هي نسبة محتوى الكحول في الدم حتى يصبح الشخص ثمل او مخمور",
                "0.06%", "0.08%", "0.10%", 2, Question.STATE_CALIFORNIA);
        addQuestion(cQ9);
        Question cQ10 = new Question("في الطرق السريعة في ولاية نيويورك عندما لا تكون علامات تحديد السرعة. فان السرعة القصوى هي...ميل في الساعة.",
                "55", "50", "60", 1, Question.STATE_CALIFORNIA);
        addQuestion(cQ10);
        Question cQ11 = new Question("قبل أن تغادر أماكن تركين السيارات الموازية لرصيف يجب عليك",
                "قم بالتأكد من محتويات السيارة", "شاهد حركة المرور بإدارة راسك الى الخلف", "قم بالتأكد من سلامة سيارتك", 2, Question.STATE_CALIFORNIA);
        addQuestion(cQ11);
        Question cQ12 = new Question("إذا كان القطار يقترب أو يسير بسرعة بما فيه الكفاية ليكون خطرا يجب عليك",
                "قم بمحاولة المرور بطريقة اخري", "اعبر المسارات بسرعة", "لا تعبر المسارات حتى يجتاز القطار تماما.", 3, Question.STATE_CALIFORNIA);
        addQuestion(cQ12);
        Question cQ13 = new Question("حزام السلامة يمكن أن يكون احسن وسيلة لتجنب الجروح خلال حوادث السير إذا …؟",
                "يستعمله السائق والراكب الأمامي فقط", "استعمله السائق والركاب بغض النظر عن مكان جلوسهم", "استعمله السائق فقط اثناء السير", 2, Question.STATE_CALIFORNIA);
        addQuestion(cQ13);
        Question cQ14 = new Question("يجب أن تسمح للعربات القادمة عندما ..؟",
                "إذا كنت تريد الانعطاف يسار", "اذا كنت تريد الانعطاف يمينا", "اذا كانت سرعتها اكثر منك", 1, Question.STATE_CALIFORNIA);
        addQuestion(cQ14);
        Question cQ15 = new Question("السرعة الآمنة لقيادة عربتك هي …؟",
                "حسب عدد الركاب", "ترتبط بحالة الطقس وحالة الطريق", "حسب خبرة السائق", 2, Question.STATE_CALIFORNIA);
        addQuestion(cQ15);
        Question cQ16 = new Question("كنت تسير في الحارة الوسطى في طريق سريع بثلاث حارات ورأيت عربة تجاوزت عربتك من اليمين هل هذا التصرف جائز؟",
                "يجوز حتي ولو كانت هناك علامة تمنع التجاوز من اليمين", "لا، لا يجوز هذا التصرف", "نعم يمكن أن يتجاوز من اليمين مادام ليست هناك اشارة او علامة تمنع التجاوز من اليمين", 3, Question.STATE_CALIFORNIA);
        addQuestion(cQ16);
        Question cQ17 = new Question("يمكن لسائق أن يركن في مساحة مخصصة للأشخاص ذوي الإعاقة إذا كانت عربته تحمل رخص لوحات الاغاقة",
                "بدون ترخيص اذا كان هناك مكان متاح", "و يحمل الشخص المعاق واسمه في التسجيل", "اذا كان مع ترخيص", 2, Question.STATE_CALIFORNIA);
        addQuestion(cQ17);
        Question cQ18 = new Question("ينبغي أن يكون سائقي السيارات على علم بأن كل الدراجات المستخدمة بعد حلول الظلام يجب أن يتوفر على",
                "مصباح رأسي و ضوء أحمر في الخلف", "مصباح رأسي فقط", "ضوء احمر في الخلف فقط", 1, Question.STATE_CALIFORNIA);
        addQuestion(cQ18);
        Question cQ19 = new Question("في الرحلات الطويلة يمكن تجنب النعاس",
                "الدردشة مع الركات", "التوقف لفترات معينة للراحة", "استخدام الهاتف للتسلية", 2, Question.STATE_CALIFORNIA);
        addQuestion(cQ19);
        Question cQ20 = new Question("عندما تكون الطريق بها خط أصفر متواصل وآخر أصفر متقطع من ناحيتك يمكن أن تتجاوز اذا ….؟",
                "كانت سرعتك ليست عالية", "كانت حركة المرور خفيفة", "كانت الطريق واضحة", 3, Question.STATE_CALIFORNIA);
        addQuestion(cQ20);
        Question cQ21 = new Question("يختلف سائق الدارجة عن سائق العربة بأنه غير ملزم بـ …؟",
                "الترخيص", "تأمين دراجته", "سن معين", 2, Question.STATE_CALIFORNIA);
        addQuestion(cQ21);
        Question cQ22 = new Question("كيف تتصرف اذا تجاوزت الخروج من الطريق السريع؟",
                "اذهب الى الخروج التالي", "استمر كما انت", "اوقف السيارة", 1, Question.STATE_CALIFORNIA);
        addQuestion(cQ22);
        Question cQ23 = new Question("ما هي الوان علامات التحذير التي تشير إلى المخاطر المقبلة، مثل المنحنيات في الطريق أو الجسور الضيقة؟",
                "سوداء", "حروف سوداء أو رموز على خلفية صفراء.", "حمراء", 2, Question.STATE_CALIFORNIA);
        addQuestion(cQ23);
        Question cQ24 = new Question("مثلت احمر وأبيض في التقاطع يعني ؟",
                "تعرجات امامك في الطريق", "توقف علي الفور", "خفف السير وكن مستعدا للوقوف اذا كان ضروري", 3, Question.STATE_CALIFORNIA);
        addQuestion(cQ24);
        Question cQ25 = new Question("الحد الأقصى للسرعة في زقاق هو:",
                "10 ميل في الساعة", "15 ميل في الساعة", "20 ميل في الساعة", 2, Question.STATE_CALIFORNIA);
        addQuestion(cQ25);
        Question cQ26 = new Question("تم توقيفك من طرف الشرطة بسبب عدم ارتداء أحد الركاب في سيارتك حزام السلامة . أي من العبارات التالية صحيح؟",
                "قد تحصل على مخالفة إذا كان الراكب اقل من 16 سنة", "قد يحصل الراكب علي المخالفة اذا كان اقل من 16 سنة", "السائق والراكب يحصلان علي مخالفة", 1, Question.STATE_CALIFORNIA);
        addQuestion(cQ26);
        Question cQ27 = new Question("يعتبر قانوني لشخص تحت سن 21 سنة من العمر القيادة مع تركيز الكحول في الدم (BAC) يصل الى ……أو أكثر",
                "90%", "في المائة", "80%", 2, Question.STATE_CALIFORNIA);
        addQuestion(cQ27);
        Question cQ28 = new Question("الخط الأصفر الصلب بجانب خط أصفر متقطع يعني أن المركبات:",
                "مقابل الخط المتقطع ممكن ان تتجاوز", "بجانب الخط المتقطع لا ممكن ان تتجاوز", "بجانب الخط المتقطع ممكن ان تتجاوز", 3, Question.STATE_CALIFORNIA);
        addQuestion(cQ28);
        Question cQ29 = new Question("يجب مراقبة المرايا الرؤية الخلفية",
                "كل ساعة وآخري", "باستمرار حتى تراقب تحركات السيارات خلفك", "اثناء ازدحام الطريق فقط", 2, Question.STATE_CALIFORNIA);
        addQuestion(cQ29);
        Question cQ30 = new Question("يجب أن تخفض ضوء سيارتك من اجل السيارات القادمة في الاتجاه المعاكس أو عندما تكون على مسافة 300 قدم من السيارة:",
                "التي تقترب اليها من الخلف", "التي تقترب اليها من الامام", "التي بجانبك", 1, Question.STATE_CALIFORNIA);
        addQuestion(cQ30);
        Question cQ31 = new Question("كي تنعطف من طريق باتجاه واحد ومتعدد الحارات إلى طريق باتجاه واحد يجب ان تنعطف من …؟",
                "الحارة الأقرب إلى الرصيف من أي جهة", "الحارة الأقرب إلى الرصيف الذي على اليسار", "الحارة الأقرب إلى الرصيف الذي على اليمين", 2, Question.STATE_CALIFORNIA);
        addQuestion(cQ31);
        Question cQ32 = new Question("الرجوع الى الخلف هي ...",
                "أمان في بعض الحالات", "شئ عادي", "دائما خطر", 3, Question.STATE_CALIFORNIA);
        addQuestion(cQ32);
        Question cQ33 = new Question("كنت تقود سيارتك على الطريق السريع بها سرعة محددة في 65 ميلا في الساعة. حركة المرور تسير بسرعة 70 ميلا في الساعة.",
                "بسرعة لا تزيد على 55 ميلا في الساعة", "بسرعة لا تزيد على 65 ميلا في الساعة", "بسرعة لا تزيد على 60 ميلا في الساعة", 2, Question.STATE_CALIFORNIA);
        addQuestion(cQ33);
        Question cQ34 = new Question("عندما تقود سيارتك على الطريق يجب …؟",
                "حرك عيناك في كل الاتجاهات للبحث عن المخاطر المحتملة", "النظر للأمام فقط والانتباه للطريق", "النظر إلي الامام والي الخلف", 1, Question.STATE_CALIFORNIA);
        addQuestion(cQ34);
        Question cQ35 = new Question("الرصيف الذي عليه طلاء ابيض يعني …؟",
                "منطقة غير مسموح بالوقوف بجانبها", "منطقة تحميل الركاب أو البريد فقط.", "منطقة يتم العمل عليها", 2, Question.STATE_CALIFORNIA);
        addQuestion(cQ35);
        Question cQ36 = new Question("إذا كان لديك الضوء الأخضر ولكن حركة المرور تسد التقاطع، يجب عليك:",
                "محاولة السير ببطء", "البدء في السير", "البقاء بعيدا عن التقاطع حتى لا يبقى هناك حركة المرور.", 3, Question.STATE_CALIFORNIA);
        addQuestion(cQ36);
        Question cQ37 = new Question("اذا لم يكن هناك ممر للمشاة ورأيت رجلين يقطعون حارتك في الأمام يجب …؟",
                "قف ثم دعهم يمرون", "استمر في السير", "استمرار السير مع توخي الحذر", 1, Question.STATE_CALIFORNIA);
        addQuestion(cQ37);
        Question cQ38 = new Question("تكون الطريق اكثر انزلاق خلال ..؟",
                "في الشتاء", "القطرات الأولى للمطر بعد فترة جفاف", "اثناء الصباح", 2, Question.STATE_CALIFORNIA);
        addQuestion(cQ38);
        Question cQ39 = new Question("في حالة لم تكن هناك علامة تحديد السرعة فان السرعة القانونية في المناطق السكنية هي….؟",
                "30 ميل في الساعة", "20 ميل في الساعة", "25 ميل في الساعة", 3, Question.STATE_CALIFORNIA);
        addQuestion(cQ39);
        Question cQ40 = new Question("يجب الموافقة على إجراء اختبار الكشف عن الكحول في دمك او النفس او البول",
                "في أي يوم صباحا", "متى كنت خلف عجلة القيادة في كاليفورنيا", "في أي وقت يناسبك", 2, Question.STATE_CALIFORNIA);
        addQuestion(cQ40);
        Question cQ41 = new Question("أي من العبارات التالية حول النقطة العمياء صحيح؟",
                "النقطة العمياء يمكن التحقق منها من خلال النظر في مرايا الرؤية الخلفية.", "يتم القضاء عليها إذا كان لديك مرآة خارجية واحدة على كل جانب من السيارة.", "الشاحنات الكبيرة لها نقط العمياء أكبر من معظم سيارات الركاب.", 3, Question.STATE_CALIFORNIA);
        addQuestion(cQ41);
        Question cQ42 = new Question("إذا كنت قاصرا و بدأ هاتفك يرن أثناء القيادة، يجب عليك:",
                "دع المكالمة تذهب الى العلبة الصوتية", "قم بالرد علي المكالمة", "قم بقفل الهاتف", 1, Question.STATE_CALIFORNIA);
        addQuestion(cQ42);
        Question cQ43 = new Question("عند تركن سيارتك موازية مع الرصيف",
                "عجلات سيارتك مقابلة للرصيف", "عجلات سيارتك يجب أن تكون موجهة نحو الرصيف", "عجلات سيارتك تكون في الناحية الاخري من الرصيف", 2, Question.STATE_CALIFORNIA);
        addQuestion(cQ43);
        Question cQ44 = new Question("في يوم عاصف جدا  كنت تقود عربتك. عاصفة ترابية تهب عبر الطريق السريع تحد من مدى الرؤية . يجب عليك أن تقودى ببطئ و تشغل…؟",
                "المصابيح الخلفية", "بوق السيارة", "المصابيح الأمامية", 3, Question.STATE_CALIFORNIA);
        addQuestion(cQ44);
        Question cQ45 = new Question("إذا كان لديك مشكلة في رؤية المركبات بسبب الغبار أو الدخان تهب عبر الطريق، يجب أن تقود سيارتك ببطئ و تستعمل…؟",
                "بوق السيارة", "المصابيح الأمامية", "المصابيح الخلفية", 2, Question.STATE_CALIFORNIA);
        addQuestion(cQ45);
        Question cQ46 = new Question("إذا كنت تقود بسرعة أكبر من المركبات الاخرى على الطريق بحارة واحدة في كل اتجاه وباستمرار تتجاوز السيارات الأخرى، سيكون لك:",
                "ستزيد من فرص الوقوع في حادثة سير", "ستتعرض لمخالفة", "يتم سحب الرخصة منك", 1, Question.STATE_CALIFORNIA);
        addQuestion(cQ46);
        Question cQ47 = new Question("من له حق الاسبقية اذا لم يكن ممر مشاة",
                "السيارات العادية", "الراجلون دائما لهم حق الاسبقية", "سيارات الشرطة", 2, Question.STATE_CALIFORNIA);
        addQuestion(cQ47);
        Question cQ48 = new Question("يجب دائما إحترام علامات التوقف أو الأضواء الساطعة عند معابر السكك الحديدية، لأن…؟",
                "يمكن ان تتوقف القطارات ولكن ببطء", "يمكن توقف القطارات مهما كانت سرعتها ولكن اتبع القانون", "القطارات سريعة وثقيلة لا يمكن أن تتوقف بسرعة.", 3, Question.STATE_CALIFORNIA);
        addQuestion(cQ48);
        Question cQ49 = new Question("ما المسافة بالقدم التى يجب ان تبعد السيارة عندما تركنها فى الجهة المقابلة لمحطة الإطفاء؟",
                "80", "75", "70", 2, Question.STATE_CALIFORNIA);
        addQuestion(cQ49);
        Question cQ50 = new Question("ما هى الحالة الذهنية التي يتصف بها السائق الذى قاد السيارة لفترة طويلة أدى ذلك إلى حالة من فقدان الوعى اللحظى؟",
                "التنويم الإيحائي أو التنويم المغناطيسي", "النويم الذهني", "الخمول الجسدي", 1, Question.STATE_CALIFORNIA);
        addQuestion(cQ50);


        // QUESTIONS_STATE_MASSACHUSETTS
        Question maQ1 = new Question("عندما تقف حافلة المدرسة مباشرة أمام المدرسة لتنزيل أو أخذ الأطفال. يمكنك المرور على أى جانب من الحافلة بسرعة لا تزيد على؟",
                "10 ميل في الساعة", "5 ميل في الساعة", "15 ميل في الساعة", 1, Question.STATE_MASSACHUSETTS);
        addQuestion(maQ1);
        Question maQ2 = new Question("قانون الموافقة الضمنية يعني",
                "موافقة السائق على أخذ اختبار النظر", "موافقة السائق على أخذ اختبار التنفس", "موافقة السائق على أخذ اختبار الذكاء", 2, Question.STATE_MASSACHUSETTS);
        addQuestion(maQ2);
        Question maQ3 = new Question("كم عدد الأشخاص الذين يمكن لمن يحمل تصريح خاص سارى كمتدرب أن يصحبهم معه في السيارة؟",
                "4 افراد", "3 افراد", "افراد أسرته بالاضافة إلى شخص واحد ليس من أفراد الأسرة", 3, Question.STATE_MASSACHUSETTS);
        addQuestion(maQ3);
        Question maQ4 = new Question("أفضل طريقة للتحدث مع السائقين الآخرين هي",
                "استخدام الهاتف المحمول", "استخدام بوق سيارتك أو الأضواء", "استخدام اشارات اليد", 2, Question.STATE_MASSACHUSETTS);
        addQuestion(maQ4);
        Question maQ5 = new Question("لو تم ضبط الراكب (18 سنة واكثر) فى المقعد الامامى لا يرتدى حزام الامان من المسؤول؟",
                "الراكب فقط", "السائق فقط", "السائق والراكب معا", 1, Question.STATE_MASSACHUSETTS);
        addQuestion(maQ5);
        Question maQ6 = new Question("في حالة لم تكن هناك علامة مخالفة لذلك. فإن الحد الأقصى للسرعة في منطقة المدرسة هي",
                "30 ميل في الساعة", "25 ميل في الساعة", "20 ميل في الساعة", 2, Question.STATE_MASSACHUSETTS);
        addQuestion(maQ6);
        Question maQ7 = new Question("كم يجب أن تكون الرؤية على الاقل فى العين الواحدة أو العينين للحصول على تصريح خاص سارى كمتدرب؟",
                "50/30", "50/20", "40/20", 3, Question.STATE_MASSACHUSETTS);
        addQuestion(maQ7);
        Question maQ8 = new Question("كم يجب أن يكون عمرك لتحصل على تصريح خاص سارى كمتدرب؟",
                "14", "16", "18", 2, Question.STATE_MASSACHUSETTS);
        addQuestion(maQ8);
        Question maQ9 = new Question("إذا كنت ترغب فى العودة إلى الطريق الرئيسى من حافة الطريق ماذا تفعل؟",
                "أبطأ ثم أدر العجلات لتصعد الى الحافة", "قم بزيادة السرعة ثم أدر العجلات", "انظر للخلف ثم أدر العجلات", 1, Question.STATE_MASSACHUSETTS);
        addQuestion(maQ9);
        Question maQ10 = new Question("اذا انفجرت عجلة السيارة أثناء القيادة ماذا تفعل؟",
                "اتصل بصديقك ليأتي ويساعدك", "أترك السيارة تسير باستقامة للأمام و أبطئ قليلاً و بالتدريج أخرج من الطريق", "اتصل بالشرطة طلبا للمساعدة", 2, Question.STATE_MASSACHUSETTS);
        addQuestion(maQ10);
        Question maQ11 = new Question("كيف يمكن للسائق أن يتواصل مع السائقين الآخرين؟",
                "اشارات اليد", "استخدام الهاتف المحمول", "الاضواء و بوق السيارة", 3, Question.STATE_MASSACHUSETTS);
        addQuestion(maQ11);
        Question maQ12 = new Question("كم من الوقت لديك إخطار إدارة المرور بعد تغيير الاسم ؟",
                "اسبوعين (14 يوم)", "اسبوع واحد", "10 أيام", 1, Question.STATE_MASSACHUSETTS);
        addQuestion(maQ12);
        Question maQ13 = new Question("إذا تعطلت السيارة على الطريق السريع أول شئ يجب ان تفعله هو؟",
                "اتصل بالشرطة", "حاول أن تخرج من الطريق", "اتصل بصديقك", 2, Question.STATE_MASSACHUSETTS);
        addQuestion(maQ13);
        Question maQ14 = new Question("ماذا يسمى الممر (حارة المرور) المتجه إلى الطريق السريع والتى تزيد السرعة به؟",
                "حارة التلاحق", "حارة المقابلة", "حارة التسارع", 3, Question.STATE_MASSACHUSETTS);
        addQuestion(maQ14);
        Question maQ15 = new Question("ما المسافة بالقدم التى يجب ان تبعد السيارة عندما تركنها فى الجهة المقابلة لمحطة الإطفاء؟",
                "80", "75", "70", 2, Question.STATE_MASSACHUSETTS);
        addQuestion(maQ15);
        Question maQ16 = new Question("عندما تركن السيارة فى شارع منحدر لاسفل ويوجد رصيف على اليمين عجلات السيارة يجب أن تواجه؟",
                "اتجاه الرصيف", "اتجاه الطريق", "اتجاه السيارة المقابلة", 1, Question.STATE_MASSACHUSETTS);
        addQuestion(maQ16);
        Question maQ17 = new Question("ما هى الحالة الذهنية التي يتصف بها السائق الذى قاد السيارة لفترة طويلة أدى ذلك إلى حالة من فقدان الوعى اللحظى؟",
                "الخمول الجسدي", "التنويم الإيحائي أو التنويم المغناطيسي", "التنويم الذهني", 2, Question.STATE_MASSACHUSETTS);
        addQuestion(maQ17);
        Question maQ18 = new Question("لو تم ضبط راكب فى المقعد الامامى عمرة 17 سنة لا يرتدي حزام الأمان على من تكون المسؤولية؟",
                "الراكب فقط", "الراكب والسائق معا", "السائق فقط", 3, Question.STATE_MASSACHUSETTS);
        addQuestion(maQ18);
        Question maQ19 = new Question("متى تحدث الكثير من الحوادث عند التقاطعات؟",
                "اثناء ازدحام حركة المرور", "فى أول ثواني بعد تغيير أضواء إشارات المرور", "اثناء الليل", 2, Question.STATE_MASSACHUSETTS);
        addQuestion(maQ19);
        Question maQ20 = new Question("إذا كنت تقود خلف حافلة المدرسة وكانت تستعمل ضوء أحمر يومض وإشارة قف يجب عليك",
                "أن تقف على الأقل على بعد 25 قدم", "أن تقف على الأقل على بعد 20 قدم", "أن تقف على الأقل على بعد 30 قدم", 1, Question.STATE_MASSACHUSETTS);
        addQuestion(maQ20);
        Question maQ21 = new Question("إذا مساحات الزجاج الأمامي الواقي توقفت فجأة أثناء المطر أو الثلج يجب عليك",
                "دحرج ( انزل) النافذة الجانبية للسائق وأخرٍجْ رأسك حتى تتمكن من الرؤية", "دوس الفرامل واسحب السيارة لجانب الطريق.", "كل الخيارات صحيحة", 3, Question.STATE_MASSACHUSETTS);
        addQuestion(maQ21);
        Question maQ22 = new Question("عند القيادة على الطرق السريعة الرئيسية يجب ؟",
                "البقاء في حالة تأهب.", "تبقي عينيك تتحركان.", "كل الخيارات صحيحة", 3, Question.STATE_MASSACHUSETTS);
        addQuestion(maQ22);
        Question maQ23 = new Question("المسافة التى تتوقف عندها السيارة لا تعتمد ابدأ على",
                "المسافة المقطوعة", "الوقت من اليوم", "السرعة", 2, Question.STATE_MASSACHUSETTS);
        addQuestion(maQ23);
        Question maQ24 = new Question("يمكن أن تركن السيارة بالتوازى مع الرصيف على بعد؟",
                "6 بوصات (إنش)", "8 بوصات (إنش)", "4 بوصات (إنش)", 1, Question.STATE_MASSACHUSETTS);
        addQuestion(maQ24);
        Question maQ25 = new Question("أنت كسائق متى يجب عليك ان توقف السيارة",
                "عندما توجد إشارة حمراء", "عندما يطلب منك شرطى الوقوف", "كل الخيارات صحيحة", 1, Question.STATE_MASSACHUSETTS);
        addQuestion(maQ25);
        Question maQ26 = new Question("على أى الطرق يمكن أن توجد الخطوط المزدوجة الصلبة السميكة؟",
                "طريق سليم ذي اتجاهين", "طريق متعرج ذي اتجاهين", "طريق متعرج ذو اتجاه واحد", 2, Question.STATE_MASSACHUSETTS);
        addQuestion(maQ26);
        Question maQ27 = new Question("عند القيادة على طريق مبلل بالمياه بسرعة 40 ميل فى الساعة. كم تكون المسافة (بطول عدد السيارات ) بينك وبين السيارة التى تتبعها؟",
                "8", "6", "10", 1, Question.STATE_MASSACHUSETTS);
        addQuestion(maQ27);
        Question maQ28 = new Question("علامة على شكل معين او ماسية الشكل تعني",
                "خفف السرعة", "علامة خطر الطريق", "توقف", 1, Question.STATE_MASSACHUSETTS);
        addQuestion(maQ28);
        Question maQ29 = new Question("لماذا لا تستطيع قطع الخط المتقطع الابيض او الاصفر؟",
                "تحتاج الي موافقة الشرطة", "قد يتم سحب الرخصة", "يمكن أن تتداخل مع حركة المرور عند القيام بذلك", 3, Question.STATE_MASSACHUSETTS);
        addQuestion(maQ29);
        Question maQ30 = new Question("علامة ممنوع التركين “NO Parking” في بعض الأماكن تعني",
                "يمكن أن تقف لحمل أو انزال الركاب", "لا يمكنك الوقوف هنا", "لا يمكنك المرور من هنا", 1, Question.STATE_MASSACHUSETTS);
        addQuestion(maQ30);
        Question maQ31 = new Question("ماذا يعني الضوء الأصفر الوامض ؟",
                "توقف بعد 5 متر", "تقدم بحذر", "خفف السرعة", 2, Question.STATE_MASSACHUSETTS);
        addQuestion(maQ31);
        Question maQ32 = new Question("يختلف سائق الدارجة عن سائق العربة بأنه غير ملزم بـ …؟",
                "ترخيص", "الخبرة", "تأمين دراجته", 3, Question.STATE_MASSACHUSETTS);
        addQuestion(maQ32);
        Question maQ33 = new Question("كيف تتصرف اذا تجاوزت الخروج من الطريق السريع؟",
                "اذهب الى الخروج التالي", "حاول العودة مرة آخري", "اوقف السيارة", 1, Question.STATE_MASSACHUSETTS);
        addQuestion(maQ33);
        Question maQ34 = new Question("عندما تقف حافلة المدرسة مباشرة أمام المدرسة لتنزيل أو أخذ الأطفال. يمكنك المرور على أى جانب من الحافلة بسرعة لا تزيد على؟",
                "20 ميل في الساعة", "10 ميل في الساعة", "15 ميل في الساعة", 2, Question.STATE_MASSACHUSETTS);
        addQuestion(maQ34);
        Question maQ35 = new Question("متى يجب عليك إبلاغ إدارة المرور بعد وقوع حادثة؟",
                "5 أيام", "7 أيام", "10 أيام", 3, Question.STATE_MASSACHUSETTS);
        addQuestion(maQ35);


        // QUESTION_STATE_MICHIGAN
        Question miQ1 = new Question("كم يجب أن يكون عمرك لتحصل على تصريح خاص سارى كمتدرب؟",
                "14", "16", "18", 2, Question.STATE_MICHIGAN);
        addQuestion(miQ1);
        Question miQ2 = new Question("كم يجب أن تكون الرؤية على الاقل فى العين الواحدة أو العينين للحصول على تصريح خاص سارى كمتدرب؟",
                "50/20", "40/20", "50/30", 1, Question.STATE_MICHIGAN);
        addQuestion(miQ2);
        Question miQ3 = new Question("لا تحتاج أن توقف سيارتك لشاحنة المثلجات الايس كريم عندما",
                "اذا كنت علي الجانب المقابل لها في طريق سريع", "اذا كنت علي الجانب الموازي لها في طريق سريع", "إذا كنت على الجانب الآخر فى طريق سريع مزدوج أو في وسطها.", 3, Question.STATE_MICHIGAN);
        addQuestion(miQ3);
        Question miQ4 = new Question("للقيادة في المدينة هناك تصرفات جيدة منها …؟",
                "عدم القيادة بسرعة أثناء الليل", "أنظر على الأقل من 12 الى 15 ثانية على الطريق لترى ما هو أمامك", "قدم القيادة بسرعة بالقرب من مدرسة", 2, Question.STATE_MICHIGAN);
        addQuestion(miQ4);
        Question miQ5 = new Question("عندما تركن سيارتك يجب ان تبتعد عن ممر الراجلين بـ … قدم",
                "25", "30", "20", 1, Question.STATE_MICHIGAN);
        addQuestion(miQ5);
        Question miQ6 = new Question("كيف يمكن لشخص سكران ان يستعيد وعيه؟",
                "شرب الماء", "الوقت", "النوم", 2, Question.STATE_MICHIGAN);
        addQuestion(miQ6);
        Question miQ7 = new Question("متى تحدث الكثير من الحوادث عند التقاطعات؟",
                "أوقات ازدحام حركة المرور", "اثناء الليل", "فى أول ثواني بعد تغيير أضواء إشارات المرور", 3, Question.STATE_MICHIGAN);
        addQuestion(miQ7);
        Question miQ8 = new Question("استخدام كلأ من أحزمة الأمان وأحزمة الكتف هى مهمة لأنها",
                "زيادة من فرصك فى البقاء على قيد الحياة", "سلامة السيارة", "الحفاظ علي محتويات السيارة", 1, Question.STATE_MICHIGAN);
        addQuestion(miQ8);
        Question miQ9 = new Question("كم من الوقت لديك إخطار إدارة المرور بعد تغيير الاسم ؟",
                "10 أيام", "أسبوع واحد", "اسبوعين (14 يوم)", 3, Question.STATE_MICHIGAN);
        addQuestion(miQ9);
        Question miQ10 = new Question("عندما يسمح القانون بالدوران جهة اليمين والإشارة حمراء يجب أن",
                "خفف السرعة مع دوران السيارة", "قف تماماً و تحقق من المرور", "تدر السيارة مباشرة", 2, Question.STATE_MICHIGAN);
        addQuestion(miQ10);
        Question miQ11 = new Question("أثناء قيادة السيارة ما هى الاشياء الثلاث التى يجب ان تكون دائما معك؟",
                "رخصة أو تصريح القيادة، وتسجيل السيارة، و بطاقة التأمين", "رخصة القيادة، زجاجة مياه، بطاقة التأمين", "رخصة أو تصريح القيادة، بطاقة التأمين، هاتف محمول", 1, Question.STATE_MICHIGAN);
        addQuestion(miQ11);
        Question miQ12 = new Question("عدم ارتدائك لحزام الأمان في المقعد الأمامي. وعدم احكام حزام الامان للطفل تحت 18 عام يعتبر …؟",
                "مخالفة عادية", "مخالفة أساسية", "مخالفة ثانوي", 2, Question.STATE_MICHIGAN);
        addQuestion(miQ12);
        Question miQ13 = new Question("متى يكون سطح الطريق أكثر أنزلاقاً؟",
                "اثناء الصباح", "في الشتاء", "خلال الدقائق الأولى من نزول المطر", 3, Question.STATE_MICHIGAN);
        addQuestion(miQ13);
        Question miQ14 = new Question("يسمح لك القانون ان تنعطف يمينا بعد ان تتوقف تماما عند الأشارة الحمراء وتسمح لكل السيارات و المشاة بالعبور إلا إذا",
                "كانت حركة المرور ليست مزدحمة", "كانت هناك علامة مرور تقول لا يسمح بالانعطاف فى حالة الضوء الأحمر", "عندما يسمح لك الشرطي بذلك", 2, Question.STATE_MICHIGAN);
        addQuestion(miQ14);
        Question miQ15 = new Question("إذا تعطلت السيارة على الطريق السريع أول شئ يجب ان تفعله هو؟",
                "حاول أن تخرج من الطريق", "اتصل بالشرطة", "اتصل بصديقك ليساعدك", 1, Question.STATE_MICHIGAN);
        addQuestion(miQ15);
        Question miQ16 = new Question("ماذا يسمى الممر (حارة المرور) المتجه إلى الطريق السريع والتى تزيد السرعة به؟",
                "حارة التلاحق", "حارة المقابلة", "حارة التسارع", 3, Question.STATE_MICHIGAN);
        addQuestion(miQ16);
        Question miQ17 = new Question("كيف يمكن للسائق أن يتواصل مع السائقين الآخرين؟",
                "الهاتف المحمول", "الاضواء و بوق السيارة", "استخدام اشارات اليد", 2, Question.STATE_MICHIGAN);
        addQuestion(miQ17);
        Question miQ18 = new Question("كل السائقين يجب أن يقودوا ببطئ عند الاقتراب من",
                "المنخفضات", "التقاطعات", "كل الخيارات صحيحة", 3, Question.STATE_MICHIGAN);
        addQuestion(miQ18);
        Question miQ19 = new Question("من الممكن أن تقود السيارة فى الممتلكات العامة أو الخاصة وذلك لتجنب أشارة أو علامة للمرور",
                "في منتصف النهار", "عندما يطلب منك ضابط البوليس أن تفعل ذلك.", "اذا كان الوضع يسمح بذلك", 2, Question.STATE_MICHIGAN);
        addQuestion(miQ19);
        Question miQ20 = new Question("ماذا يجب ان تفعل فى حالة وقوع حادثة؟",
                "أطلب الشرطة وأدلى بالمعلومات", "توقف وأطلب المساعدة", "كل الخيارات صحيحة", 3, Question.STATE_MICHIGAN);
        addQuestion(miQ20);
        Question miQ21 = new Question("ماذا تفعل لتتجنب (هيدرو بلاننج) الإنزلاق فوق الماء؟",
                "لا تقود في الماء الراكد أو في الوحل", "أبطأ عند وجود أمطار غزيرة", "كل الاجوبة صحيحة", 3, Question.STATE_MICHIGAN);
        addQuestion(miQ21);
        Question miQ22 = new Question("إذا كان لابد من الإصطدام يجب عليك",
                "أن تختار الاصطدام بشيء سيعطيك طريق أفضل من شئ صلب", "أن تختار الاصطدام بشيء قائم افضل من شئ قادم فى اتجاهك", "كل الخيارات صحيحة", 3, Question.STATE_MICHIGAN);
        addQuestion(miQ22);
        Question miQ23 = new Question("يجب دائما إحترام علامات التوقف أو الأضواء الساطعة عند معابر السكك الحديدية، لأن…؟",
                "قد يتم سحب الرخصة", "القطارات سريعة وثقيلة لا يمكن أن تتوقف بسرعة.", "القطارات سريعة وثقيلة ولكن يمكن أن تتوقف بسرعة.", 2, Question.STATE_MICHIGAN);
        addQuestion(miQ23);
        Question miQ24 = new Question("يجب تشغيل المصابيح الأمامية الخاصة بك:",
                "نصف ساعة قبل شروق الشمس", "نصف ساعة بعد غروب الشمس", "كل الخيارات صحيحة", 3, Question.STATE_MICHIGAN);
        addQuestion(miQ24);
        Question miQ25 = new Question("أنت كسائق متى يجب عليك ان توقف السيارة",
                "عندما توجد إشارة حمراء", "عندما يطلب منك شرطى الوقوف", "كل الخيارات صحيحة", 3, Question.STATE_MICHIGAN);
        addQuestion(miQ25);
        Question miQ26 = new Question("ماهي القيادة طبقا لقانون الولاية؟",
                "امتياز", "خبرة", "مهارة", 1, Question.STATE_MICHIGAN);
        addQuestion(miQ26);
        Question miQ27 = new Question("إذا مساحات الزجاج الأمامي الواقي توقفت فجأة أثناء المطر أو الثلج يجب عليك",
                "دوس الفرامل واسحب السيارة لجانب الطريق.", "دحرج ( انزل) النافذة الجانبية للسائق وأخرٍجْ رأسك حتى تتمكن من الرؤية", "كل الخيارات صحيحة", 3, Question.STATE_MICHIGAN);
        addQuestion(miQ27);
        Question miQ28 = new Question("ماذا يمكن أن يحدث للشخص المضيف إذا ترك الضيف يغادر منزل الضيافة وهو في حالة سكر وتورط في حادثة؟",
                "سجن 3 سنوات", "دعوة قضائية", "غرامة مالية", 2, Question.STATE_MICHIGAN);
        addQuestion(miQ28);
        Question miQ29 = new Question("ما هو لون العلامات التى تُخبرُ بمعلومات؟",
                "الازرق أو الاخضر", "الاسود والاحمر", "الاصفر والاحمر", 1, Question.STATE_MICHIGAN);
        addQuestion(miQ29);
        Question miQ30 = new Question("عندما يكون الضوء أحمر والسهم أخضر فهذا يعني …؟",
                "تحذير هناك أعمال بناء علي الطريق", "يجب أن تذهب فقط في اتجاه السهم الأخضر", "يجب أن تخفض السرعة", 2, Question.STATE_MICHIGAN);
        addQuestion(miQ30);
        Question miQ31 = new Question("علامة على شكل معين او ماسية الشكل تعني",
                "علامة خطر الطريق", "توقف", "خفف السرعة", 1, Question.STATE_MICHIGAN);
        addQuestion(miQ31);
        Question miQ32 = new Question("اذا كانت هناك علامة لا تدور في الاحمر، متى يمكن لك تغير الاتجاه نحو اليمين في الضوء الاحمر؟",
                "بعد 5 دقائق", "في نفس الوقت", "أبدا", 3, Question.STATE_MICHIGAN);
        addQuestion(miQ32);
        Question miQ33 = new Question("من العلامات الواضحة التى تدل على سكر السائق",
                "القيادة ببطء أكثر من حركة المرور", "الترنح بين الممرات", "كل الاجابات صحيحة", 3, Question.STATE_MICHIGAN);
        addQuestion(miQ33);
        Question miQ34 = new Question("إذا كنت ترغب فى العودة إلى الطريق الرئيسى من حافة الطريق ماذا تفعل؟",
                "توجه مباشرة بسرعتك الحالية الي الحافة", "أبطأ ثم أدر العجلات لتصعد الى الحافة", "زود السرعة ثم أدر العجلات لتصعد الي الحافة", 2, Question.STATE_MICHIGAN);
        addQuestion(miQ34);
        Question miQ35 = new Question("محتوى الكحول في الدم (BAC) يعتمد على كل مما يلي ما عدا",
                "شكل جسمك", "درجة الحرارة", "حالتك الذهنية", 1, Question.STATE_MICHIGAN);
        addQuestion(miQ35);


        // QUESTIONS_STATE_NEWJERSEY
        Question nQ1 = new Question("إذا رسب الطالب في اختبار القيادة للمرة الأولى. حتى متى يجب عليه الانتظار قبل أن يتمكن من اتخاذ الامتحان مرة أخرى؟",
                "اسبوعين على الاقل", "اسبوع واحد", "10 أيام", 1, Question.STATE_NEWJERSEY);
        addQuestion(nQ1);
        Question nQ2 = new Question("بموجب قانون ولاية نيوجيرسى لنظام النقاط.الشخص الذى عنده رخصة قيادة لأكثر من عامين بعد كم نقطة سيتم إخطاره بإيقاف الرخصة؟",
                "14", "12", "10", 2, Question.STATE_NEWJERSEY);
        addQuestion(nQ2);
        Question nQ3 = new Question("متى يمكن تشغيل ضوء تغير الاتجاه عند ما تريد تغير الاتجاه؟",
                "ما لا يقل عن 150 قدم قبل تقاطع", "ما لا يقل عن 80 قدم قبل تقاطع", "ما لا يقل عن 100 قدم قبل تقاطع", 3, Question.STATE_NEWJERSEY);
        addQuestion(nQ3);
        Question nQ4 = new Question("مسافة توقف السيارة بعيدا عن علامة  قف؟",
                "30 قدما", "50 قدما", "40 قدما", 2, Question.STATE_NEWJERSEY);
        addQuestion(nQ4);
        Question nQ5 = new Question("مسافة تركين سيارتك بعيدا عن زاوية؟",
                "25 قدما", "30 قدما", "20 قدما", 1, Question.STATE_NEWJERSEY);
        addQuestion(nQ5);
        Question nQ6 = new Question(" مسافة تركين سيارتك بعيدا عن صنبورالاطفاء الخاص برجال المطافىء؟",
                "20 قدم", "15 قدم", "10 أقدام", 3, Question.STATE_NEWJERSEY);
        addQuestion(nQ6);
        Question nQ7 = new Question("ما هي المسافة التوقف على طريق جاف بسرعة 50 ميلا في الساعة؟",
                "243 قدم", "143 قدم", "343 قدم", 1, Question.STATE_NEWJERSEY);
        addQuestion(nQ7);
        Question nQ8 = new Question("مسافة توقفك بعيدا عن منعطف؟",
                "10 بوصات أو أقل", "8 بوصات أو أقل", "6 بوصات أو أقل", 3, Question.STATE_NEWJERSEY);
        addQuestion(nQ8);
        Question nQ9 = new Question("ما هي العقوبات المفروضة على القيادة من دون تأمين؟",
                "تعليق رخصة القيادة", "تعليق رخصة القيادة وتسجيل والغرامات", "تسجيل الغرامات", 2, Question.STATE_NEWJERSEY);
        addQuestion(nQ9);
        Question nQ10 = new Question("يجب الإبلاغ عن الحوادث الخطيرة المسببة للموت أو الإصابة أو 200 دولار اعطاب في غضون 5 أيام",
                "ادارة محرك السيارة", "الشرطة العامة", "مكتب التحقيقات", 1, Question.STATE_NEWJERSEY);
        addQuestion(nQ10);
        Question nQ11 = new Question("تسحب منك النقط فقط في حالة",
                "استخدام الهاتف المحمول", "القيادة بسرعة اثناء الليل", "مخالفات المرور", 3, Question.STATE_NEWJERSEY);
        addQuestion(nQ11);
        Question nQ12 = new Question("ما هي عقوبة القيادة عندما تكون رخصتك موقوفة؟",
                "غرامة قدرها 500 دولار مع اضافة 6 اشهر اخرى لمدة تعليق رخصتك", "غرامة قدرها 800 دولار مع اضافة 8 اشهر اخرى لمدة تعليق رخصتك", "غرامة قدرها 500 دولار مع اضافة 3 اشهر اخرى لمدة تعليق رخصتك", 1, Question.STATE_NEWJERSEY);
        addQuestion(nQ12);
        Question nQ13 = new Question("ما هي عقوبة لعدم قول الحقيقة عند التقدم بطلب للحصول على ترخيص؟",
                "ما لا يقل عن 300 $ و السجن وغرامة تصل إلى 3 أشهر", "ما لا يقل عن 500 $ و السجن وغرامة تصل إلى 6 أشهر", "ما لا يقل عن 200 $ و السجن وغرامة تصل إلى 6 أشهر", 3, Question.STATE_NEWJERSEY);
        addQuestion(nQ13);
        Question nQ14 = new Question("قد تحذف ما يصل الى 3 نقاط من السجل الخاص بك إذا لم تتلقى أي مخالفة خلال ؟",
                "سنة واحدة", "6 أشهر", "سنتان", 1, Question.STATE_NEWJERSEY);
        addQuestion(nQ14);
        Question nQ15 = new Question("ماهي عقوبة رفض اجراء اختبار  الكشف عن نسبة الكحول في الدم",
                "سحب الرخصة لمدة ستة اشهر مع غرامة 800 دولار في حالة اول مخالفة", "سحب الرخصة لمدة ستة اشهر في حالة اول مخالفة", "سحب الرخصة لمدة سنة في حالة اول مخالفة", 2, Question.STATE_NEWJERSEY);
        addQuestion(nQ15);
        Question nQ16 = new Question("من هو المسؤول إذا ارتكب متعلم القيادة مخالفة مرورية؟",
                "الطالب والسائق المرافق فقط", "المدرس والسائق المرافق فقط", "كل من الطالب والمدرس أو السائق المرافق", 3, Question.STATE_NEWJERSEY);
        addQuestion(nQ16);
        Question nQ17 = new Question("ماذا يجب ان تفعل إذا اقتربت من  الأصفر لامع أو إشارة العنبر؟",
                "تمهل ، وقف قبل دخول التقاطع إذا كان ممكنا فقط", "b", "c", 1, Question.STATE_NEWJERSEY);
        addQuestion(nQ17);
        Question nQ18 = new Question("ما هي الممارسات الجيدة أثناء القيادة؟",
                "a", "عدم التركيز على  مشاهدة شيء واحد لأكثر من بضع ثوان", "c", 2, Question.STATE_NEWJERSEY);
        addQuestion(nQ18);
        Question nQ19 = new Question("ما هو الممر الصحيح لتتحول عند اتخاذ منحى اليسار؟",
                "حارة أقرب مركز في الاتجاه الذي تسير اليه", "حارة أقرب مركز في الاتجاه عكس الذي تسير اليه", "حارة أقرب مركز في أي اتجاه", 1, Question.STATE_NEWJERSEY);
        addQuestion(nQ19);
        Question nQ20 = new Question("عند القيادة في الليل يجب أن تكون قادرا على الوقوف؟",
                "علي بعد 100 قدم", "علي بعد 50 قدم", "على مسافة يمكنك ان ترى من قبل", 3, Question.STATE_NEWJERSEY);
        addQuestion(nQ20);
        Question nQ21 = new Question("أين يجب توجيه سيارتك ادا كنت قادم من شارع باتجاهين وتريد تغير الاتجاه نحو اليسار؟",
                "حارة أقرب مركز من الطريق في الإتجاه المعاكس", "حارة أقرب مركز من الطريق", "حارة أبعد مركز من الطريق", 2, Question.STATE_NEWJERSEY);
        addQuestion(nQ21);
        Question nQ22 = new Question("ما هي الممارسة الجيدة عندما تقترب من تقاطع؟",
                "تمهل وكن مستعدا للوقوف", "قم بزيادة السرعة", "زيادة السرعة مع توخي الحذر", 1, Question.STATE_NEWJERSEY);
        addQuestion(nQ22);
        Question nQ23 = new Question("ما هو الغرض من قوانين السير؟",
                "للحفاظ علي نظامة الطرق", "للحفاظ علي الممتلكات العامة", "لحمايتك وحماية السائقين الآخرين", 3, Question.STATE_NEWJERSEY);
        addQuestion(nQ23);
        Question nQ24 = new Question("اذا كانت هناك علامة لا تدور في الاحمر، متى يمكن لك تغير الاتجاه نحو اليمين في الضوء الاحمر؟",
                "أبدا", "في نفس الوقت", "بعد مرور 5 دقائق", 1, Question.STATE_NEWJERSEY);
        addQuestion(nQ24);
        Question nQ25 = new Question("إذا كنت تشعر أو تسمع  ضجيج غير عادي أثناء القيادة قد يكون؟",
                "الفرامل", "العجلات", "المحرك", 2, Question.STATE_NEWJERSEY);
        addQuestion(nQ25);
        Question nQ26 = new Question("ما هي أفضل نصيحة إذاتوقفت  سيارتك في عاصفة ثلجية ثقيلة؟",
                "اخرج من السيارة وحاول الذهاب للمنزل", "اخرج من السيارة واطلب المساعدة", "البقاء داخل سيارتك", 3, Question.STATE_NEWJERSEY);
        addQuestion(nQ26);
        Question nQ27 = new Question("ما هي الممارسات الجيدة أثناء القيادة في المدينة؟",
                "الانتباه المسبق لاشارات ملتقيات الطرق", "عدم القيادة بسرعة في منطقة مدرسة", "عدم القيادة في الطرق المتعرجة ليلا", 1, Question.STATE_NEWJERSEY);
        addQuestion(nQ27);
        Question nQ28 = new Question("ماذا يجب عليك فعله إذا كنت تريد أن ينعطف يسارا عند إشارة المرور؟",
                "الإنعطاف مباشرة مع توخي الحذر", "اعطاء حق الاسبقية للقادمين", "زيادة السرعة مع الإنعطاف مباشرة", 2, Question.STATE_NEWJERSEY);
        addQuestion(nQ28);
        Question nQ29 = new Question("متى سيتم اشعارك بسحب رخصتك ؟",
                "بعد تلقيك لـ 14 نقطة", "بعد تلقيك لـ 12 نقطة", "بعد تلقيك لـ 10 نقاط", 2, Question.STATE_NEWJERSEY);
        addQuestion(nQ29);
        Question nQ30 = new Question("إذا كان الجزء الأمامي من السيارة يهتز، قد تكون المشكلة:",
                "الفرامل", "المحرك", "أعمدة او نوابض العجلات", 3, Question.STATE_NEWJERSEY);
        addQuestion(nQ30);
        Question nQ31 = new Question("ماذا يعني الخطين المتوازين بلون ابيض ؟",
                "ممر مشا", "انتبه", "قف", 1, Question.STATE_NEWJERSEY);
        addQuestion(nQ31);
        Question nQ32 = new Question("مانوع الاضواء التي يجب ان تستعمل في الضباب؟",
                "الضوء الخلفي", "الضوء المنخفض او ضوء الضباب", "الضوء العالي", 2, Question.STATE_NEWJERSEY);
        addQuestion(nQ32);
        Question nQ33 = new Question("ماهي اوراق السيارة التي يجب ان تحمل معك؟",
                "بطاقة التأمين فقط", "الترخيص والتسجيل فقط", "الترخيص والتسجيل ، وبطاقة التأمين", 3, Question.STATE_NEWJERSEY);
        addQuestion(nQ33);
        Question nQ34 = new Question("متي يجب استعمال بوق السيارة؟",
                "عند الخروج من زقاق مظلم", "في الطرق السريعة", "عند القيادة في اثناء الليل", 1, Question.STATE_NEWJERSEY);
        addQuestion(nQ34);
        Question nQ35 = new Question("من له حق الاسبقية في ملتقى طرق بدون اشارات او غير مراقب؟",
                "الأسرع له أسبقية المرور", "السائق الذي يوجد يمينك له اسبقية المرور", "السائق الذي يوجد يسارك له اسبقية المرور", 2, Question.STATE_NEWJERSEY);
        addQuestion(nQ35);
        Question nQ36 = new Question("الخط الاصفر الوسطي يكون عادة في؟",
                "الطرق الواسعة التي لا يوجد بها اشارات", "الطرق السريعة التي بها تعرجات", "على طريق باتجاهين ولايسمح التجاوز عندها", 3, Question.STATE_NEWJERSEY);
        addQuestion(nQ36);
        Question nQ37 = new Question("لماذا ينبغي عليك استخدام أحزمة الأمان وأحزمة الكتف؟",
                "أنها تزيد من فرص نجاتك من حادث", "لضمان سلامة محتويات السيارة", "حتي لا تتعرض لغرامة مالية", 1, Question.STATE_NEWJERSEY);
        addQuestion(nQ37);
        Question nQ38 = new Question("متى يمكن تجازو سيارة من اليمين؟",
                "اذا كانت سرعتك أعلي من سرعتها", "إذا كانت السيارة التي أمامك تريد تغير الاتجاه نحو اليسار وكان هناك ممر للقيادة على اليمين", "اذا كانت السيارة التي أمامك تقود بطريقة سيئة", 2, Question.STATE_NEWJERSEY);
        addQuestion(nQ38);
        Question nQ39 = new Question("ماذا يعني الضوء الاحمر الوامض؟",
                "توجد اعمال بناء علي الطريق", "يوجد منحني أمامك", "قف ، وامضي بحذر", 3, Question.STATE_NEWJERSEY);
        addQuestion(nQ39);
        Question nQ40 = new Question("ماذا يعني الضوء الأخضر؟",
                "تقدم ان كان امنا", "قف ، وامضي بحذر", "توجد اعمال بناء علي الطريق", 1, Question.STATE_NEWJERSEY);
        addQuestion(nQ40);
        Question nQ41 = new Question("ماذا يعني الخط الصلب الابيض في ملتقى الطرق؟",
                "قف ، وامضي بحذر", "يجب الوقوف وراء الخط في انتضار اشارة المرور", "تقدم ان كان امنا", 2, Question.STATE_NEWJERSEY);
        addQuestion(nQ41);
        Question nQ42 = new Question("ماذا تعني العلامة الصفراء على شكل ماس",
                "توجد اعمال بناء علي الطريق", "تقدم ان كان امنا", "انذار او تحذير", 3, Question.STATE_NEWJERSEY);
        addQuestion(nQ42);
        Question nQ43 = new Question("متى ينبغي استعمال اضواء التوقف Parking",
                "فقط عند وقوف السيارات", "بعد تشغيل السيارة", "عندما تبدأ في التوقف", 1, Question.STATE_NEWJERSEY);
        addQuestion(nQ43);
        Question nQ44 = new Question("اين توجه سيارتك في حالة انزلاق؟",
                "في الاتجاه المقابل للسيارة", "في اتجاه انزلاق الجزء الخلفي من السيارة", "في اتجاه الرصيف", 2, Question.STATE_NEWJERSEY);
        addQuestion(nQ44);
        Question nQ45 = new Question("كيف ينبغي عليك البقاء بعيدا وراء السيارةالتي امامك؟",
                "ما لا يقل عن 4 ثواني", "ما لا يقل عن 3 ثواني", "ما لا يقل عن ثانيتين", 3, Question.STATE_NEWJERSEY);
        addQuestion(nQ45);
        Question nQ46 = new Question("ما هو الاتجاه الذي يجب التحقق منه اولا اذا اقتربت من تقاطع",
                "اليسار", "الإتجاه المعاكس", "اليمين", 1, Question.STATE_NEWJERSEY);
        addQuestion(nQ46);
        Question nQ47 = new Question("اذا وصلت سيارتين في نفس الوقت الى اربع اتجاهات قف ماهو السلوك المتبع",
                "أي منهما يسمح للآخر", "السائق على اليسار يسمح للسائق على اليمين", "السائق على اليمين يسمح للسائق على اليسار", 2, Question.STATE_NEWJERSEY);
        addQuestion(nQ47);
        Question nQ48 = new Question("ماذا تفعل في حالة إنزلاق",
                "زيادة السرعة", "اوقف السيارة", "ارفع رجلك عن دواسة البنزين", 3, Question.STATE_NEWJERSEY);
        addQuestion(nQ48);
        Question nQ49 = new Question("ما هو الخطأ الأكثر شيوعا عند السائقين الجدد؟",
                "الضغط على الفرامل بقوة", "استخدام الهاتف المحمول", "النظر للخلف بكثرة", 1, Question.STATE_NEWJERSEY);
        addQuestion(nQ49);
        Question nQ50 = new Question("ما هو أفضل وسيلة لاجراء محادثات مع السائقين الآخرين؟",
                "التحدث اليهم", "من خلال استخدام بوق سيارتك وأضواء", "استخدام اشارات اليد", 2, Question.STATE_NEWJERSEY);
        addQuestion(nQ50);
        Question nQ51 = new Question("ماذا تعني العلامة الثمانية الاضلاع الحمراء اللون؟",
                "خفف السرعة", "تحذير", "علامة قف", 3, Question.STATE_NEWJERSEY);
        addQuestion(nQ51);
        Question nQ52 = new Question("ماذا تعني العلامة الثلاثية الحمراء والصفراء",
                "مسموح", "غير مسموح", "قف", 1, Question.STATE_NEWJERSEY);
        addQuestion(nQ52);
        Question nQ56 = new Question("اذا قمت بالقيادة على بركة عميقة يجب؟",
                "اختبار عجلات السيارة", "اختبار الفرامل", "اختبار المحرك", 2, Question.STATE_NEWJERSEY);
        addQuestion(nQ56);
        Question nQ57 = new Question("متى يكون سطح الطريق زلق أكثر؟",
                "اثناء الصبح", "في الشتاء", "خلال الدقائق القليلة الأولى من المطر", 3, Question.STATE_NEWJERSEY);
        addQuestion(nQ57);
        Question nQ58 = new Question("متى ينبغي استعمال الاضواء العالية؟",
                "في حالة القيادة في طريق بها حركة سير قليلة", "في حالة القيادة في طريق بها حركة سير كثيفة", "اثناء القيادة في الليل", 1, Question.STATE_NEWJERSEY);
        addQuestion(nQ58);
        Question nQ59 = new Question("إذا كانت اضواء السيارات القادمة متوجه الي عينيك مباشرة، ماذا يجب ان تفعل؟",
                "انظر إلي الأعلي", "انظر إلى الجانب الأيمن السفلي من حارة المرور الخاصة بك", "انظر إلى الجانب الأيسر السفلي من حارة المرور الخاصة بك", 2, Question.STATE_NEWJERSEY);
        addQuestion(nQ59);
        Question nQ60 = new Question("اذا رفع السائق يده اليسرى فهذا يعني؟",
                "انه يريد ان يستمر في نفس الاتجاه", "انه يريد ان يدور يسارا", "انه يريد ان يدور يمينا", 3, Question.STATE_NEWJERSEY);
        addQuestion(nQ60);
        Question nQ61 = new Question("اذا اخرج السائق يده من النافدة بشكل مستقيم فهذا يعني؟",
                "يريد تغير الاتجاه يسارا", "انه يريد ان يدور يمينا", "انه يريد ان يستمر في نفس الاتجاه", 1, Question.STATE_NEWJERSEY);
        addQuestion(nQ61);
        Question nQ62 = new Question("اذا انزل السائق يده نحو الاسفل يعني",
                "يريد تغير الاتجاه يسارا", "يريد ان يقف او يخفف السير", "انه يريد ان يدور يمينا", 2, Question.STATE_NEWJERSEY);
        addQuestion(nQ62);
        Question nQ63 = new Question("الطريقة الأسلم للخروج من الطريق السريع هو؟",
                "كما بالخروج مباشرة بسرعتك الحالية", "قم بزيادة السرعة ثم أدر العجلات", "بطء السيارة إلى الحد الأقصى للسرعة", 3, Question.STATE_NEWJERSEY);
        addQuestion(nQ63);
        Question nQ64 = new Question("ماذا يجب ان تفعل اذا الفرامل فشلت؟",
                "حول مغير السرعة الى اسفل سرعة وضخ الفرامل", "اتصل بصديقك ليساعدك", "قم بإيقاف السيارة", 1, Question.STATE_NEWJERSEY);
        addQuestion(nQ64);
        Question nQ65 = new Question("ماذا يجب ان تفعل اذا الإشارة الكهربائية لسيارتك لا تعمل؟",
                "التحدث بالفم", "استخدام اشارة يدوية", "استخدام الهاتف المحمول", 2, Question.STATE_NEWJERSEY);
        addQuestion(nQ65);
        Question nQ66 = new Question("ماذا يجب ان تفعل إذا كان لديك انفجار؟",
                "اتصل بصديقك", "اتصل بالشرطة", "تبطئ تدريجيا", 3, Question.STATE_NEWJERSEY);
        addQuestion(nQ66);
        Question nQ67 = new Question("أسلوب واحد استخدام القاعدة الثانية هي استخدام",
                "اصلاح شيء على جانب الطريق", "فقدان شئ من محتويات السيارة", "الحاجه الي شاحن للهاتف", 1, Question.STATE_NEWJERSEY);
        addQuestion(nQ67);
        Question nQ68 = new Question("ماذا يجب ان تفعل اذا تجاوزت الخروج على طريق سريع؟",
                "قم بالسير الي الخلف", "اذهب الى الخروج القادم. لا تقوم بالسير الى الخلف", "قم بإيقاف السيارة", 2, Question.STATE_NEWJERSEY);
        addQuestion(nQ68);
        Question nQ69 = new Question("عندما كنت تقود سيارتك على منحنى ، سوف تذهب سيارتك في أي اتجاه؟",
                "يسار", "يمين", "مستقيم", 3, Question.STATE_NEWJERSEY);
        addQuestion(nQ69);
        Question nQ70 = new Question("عندما توقف الحافلة المدرسية في مدرسة لحمل الأطفال ، قد تمر في كلا الاتجاهين بسرعة لا تزيد عن:",
                "10 ميلا في الساعة", "15 ميلا في الساعة", "20 ميلا في الساعة", 1, Question.STATE_NEWJERSEY);
        addQuestion(nQ70);


        // QUESTIONS_STATE_NEWYORK
        Question nyQ1 = new Question("ماذا سيحدث لرخصة القيادة الخاصة بك إذا رفضت الخضوع لاختبار المواد الكيميائية (التنفس أو الدم)؟",
                "سحب الرخصة", "تعليقها لمدة سنة", "إلغاء تفعيلها", 1, Question.STATE_NEWYORK);
        addQuestion(nyQ1);
        Question nyQ2 = new Question("في الطرق السريعة في ولاية نيويورك عندما لا تكون علامات تحديد السرعة. فان السرعة القصوى هي ... ميل في الساعة.",
                "60", "55", "50", 2, Question.STATE_NEWYORK);
        addQuestion(nyQ2);
        Question nyQ3 = new Question("عندما تخرج العجلات اليمنى عن الطريق نحو الحاشية اللينة ما هي أفضل وسيلة للعودة مرة أخرى إلى الطريق السريع؟",
                "قم بزيادة السرعة ثم أدر العجلات مباشرة", "قم بخفض السرعة وأدر العجلات", "ارفع قدمك على دواسة الغاز وفرامل بلطف.", 3, Question.STATE_NEWYORK);
        addQuestion(nyQ3);
        Question nyQ4 = new Question("تريد الرجوع بالخلف من ممر خاص . ورأيت الأطفال يلعبون في مكان قريب. قبل البدء في تحريك سيارتك يجب عليك … ؟",
                "تمشى الى وراء السيارة حتى تتأكد من عدم وجود أطفال هناك", "الرجوع الي الخلف مباشرة", "الرجوع الي الخلف من استخدام ابواق السيارة", 1, Question.STATE_NEWYORK);
        addQuestion(nyQ4);
        Question nyQ5 = new Question("بدأت سيارتك في الانزلاق على الطرق الزلقة. يجب",
                "أدر المقود نحو اليسار", "أدر المقود نحو الاتجاه الذي تريد ان تذهب اليه العجلات", "أدر المقود نحو اليمين", 2, Question.STATE_NEWYORK);
        addQuestion(nyQ5);
        Question nyQ6 = new Question("عند اقترابك من ملتقى الطرق يتغير الضوء الاخضر الى الاصفر فإن أحسن فعل يجب عمله من بين التالي هو",
                "زيادة السرعة", "وقف السيارة", "يجب أن تكون مستعدا للوقوف قبل وصول التقاطع", 3, Question.STATE_NEWYORK);
        addQuestion(nyQ6);
        Question nyQ7 = new Question("يمكن أن تتجاوز عربة اخرى من اليمين في حالة",
                "إذا كانت تريد ان تنعطف يمينا", "إذا كانت تريد ان تنعطف يسارا", "إذا كانت تريد ان تتوقف", 1, Question.STATE_NEWYORK);
        addQuestion(nyQ7);
        Question nyQ8 = new Question("كنت تقود عربتك في الشارع وسمعت صفارات الإنذار. وكنت لا تستطيع أن ترى على الفور سيارة حالات الطوارئ. يجب",
                "استمر بالقيادة مع خفض السرعة", "توجه نحو الرصيف وقف ثم تحقق هل هي في نفس الشارع", "قم بالقيادة حتي تري السيارة", 2, Question.STATE_NEWYORK);
        addQuestion(nyQ8);
        Question nyQ9 = new Question("يستخدم الاختبار الكيميائي لقياس",
                "نسبة صحة النظر", "نسبة الذكاء", "نسبة الكحول في الدم.", 3, Question.STATE_NEWYORK);
        addQuestion(nyQ9);
        Question nyQ10 = new Question("السرعة الآمنة لقيادة عربتك هي …؟",
                "ترتبط بحالة الطقس وحالة الطريق", "ترتبط بحالة النظر", "ترتبط بالحالة الصحية", 1, Question.STATE_NEWYORK);
        addQuestion(nyQ10);
        Question nyQ11 = new Question("إذا كنت راكن عربتك على جانب الرصيف يمكن أن تخرج من سيارتك من ناحية حركة المرور",
                "حسب حالة حركة المرور", "عندما لا تريد التداخل مع السائقين الآخرين", "في أي وقت", 2, Question.STATE_NEWYORK);
        addQuestion(nyQ11);
        Question nyQ12 = new Question("عندما تريد إيقاف سيارتك في الثلج فإن أحسن فعل هو ....؟",
                "قم بسحب يدك من علي البنزين", "قم بالفرملة بقوة مرة واحدي", "قم بالفرملة ببطء و ضربات ثابتة", 3, Question.STATE_NEWYORK);
        addQuestion(nyQ12);
        Question nyQ13 = new Question("عندما تصل إلى تقاطع ثم اغلاقه من طرف عربات حركة المرور الاخرى يجب ان ..؟",
                "ابقى خارج التقاطع حتى يمكن لك المرور فيه", "b", "c", 1, Question.STATE_NEWYORK);
        addQuestion(nyQ13);
        Question nyQ14 = new Question("قبل أن تغادر أماكن تركين السيارات الموازية لرصيف يجب عليك",
                "التأكد من الفرامل", "شاهد حركة المرور بإدارة راسك الى الخلف", "التأكد من سلامة محتويات السيارة", 2, Question.STATE_NEWYORK);
        addQuestion(nyQ14);
        Question nyQ15 = new Question("علامة لا تقف أو ممنوع الوقوف No Stopping تعني بغض النظر عن أوامر الشرطة يجب أن تقف فقط",
                "عندما تريد ان تستقل صديقك", "لتنزيل الركاب", "لتفادي الصدام مع عربات حركة المرور", 3, Question.STATE_NEWYORK);
        addQuestion(nyQ15);
        Question nyQ16 = new Question("لماذا لا تستطيع قطع الخط المتقطع الابيض او الاصفر؟",
                "يمكن أن تتداخل مع حركة المرور عند القيام بذلك", "قد يتم سحب رخصتك", "دفع غرامة مالية", 1, Question.STATE_NEWYORK);
        addQuestion(nyQ16);
        Question nyQ17 = new Question("كنت تقود عربتك في الشارع وسمعت صفارات الإنذار. وكنت لا تستطيع أن ترى على الفور سيارة حالات الطوارئ. يجب",
                "استمر بالقيادة مع خفض السرعة", "انحني يمينا نحو الرصيف وقف ثم تحقق هل هي في نفس الشارع", "استمر بالقيادة حتي تري السيارة", 2, Question.STATE_NEWYORK);
        addQuestion(nyQ17);
        Question nyQ18 = new Question("لماذا القيادة على الطريق السريع تختلف عن القيادة على الشارع العادي",
                "الحد الادني للقيادة علي الطريق السريع 21 عام.", "القيادة علي الطريق السريع تحتاج الي ترخيص.", "يجب أن تفكر أسرع والتعامل مع المركبة بشكل أكثر فعالية.", 3, Question.STATE_NEWYORK);
        addQuestion(nyQ18);
        Question nyQ19 = new Question("إذا كنت تشرب الكحول في بعض المناسبات فقط ؛ ما الذي  يساعد على ضمان القيادة الآمنة؟",
                "شرب القهوة قبل القيادة", "النوم فترة طويلة قبل القيادة", "شرب الماء قبل القيادة", 1, Question.STATE_NEWYORK);
        addQuestion(nyQ19);
        Question nyQ20 = new Question("علامة تحديد السرعة هي من اجل ؟",
                "تنبيه لخفض السرعة", "الحفاض على سير حركة المرور بسلاسة", "تنبيه لزيادة السرعة", 2, Question.STATE_NEWYORK);
        addQuestion(nyQ20);
        Question nyQ21 = new Question("شرب القهوة بعد شرب الكحول",
                "له تأثير خفيف ويحتاج بعض الوقت", "لديه تأثير قوي ويلغي مفعول الكحول", "لا يوجد لديه تأثير على محتوى الكحول في الدم.", 3, Question.STATE_NEWYORK);
        addQuestion(nyQ21);
        Question nyQ22 = new Question("كنت تقود عربتك  في  الشارع وسمعت صفارات الإنذار.وكنت لا تستطيع  أن ترى على الفور سيارة  حالات الطوارئ. يجب",
                "انحني يمينا نحو الرصيف وقف ثم تحقق هل هي في نفس الشارع", "b", "c", 1, Question.STATE_NEWYORK);
        addQuestion(nyQ22);
        Question nyQ23 = new Question("على أى الطرق يمكن أن توجد الخطوط المزدوجة الصلبة السميكة؟",
                "طريق سليم ذي اتجاهين", "طريق متعرج ذي اتجاهين", "طريق متعرج ذو اتجاه واحد", 2, Question.STATE_MASSACHUSETTS);
        addQuestion(nyQ23);
        Question nyQ24 = new Question("اذا كنت في تقاطع وكان لديك الاخضر لكن حركة المرور كثيفة تمنعك من الانعطاف ماذا يجب ان تفعل ؟",
                "استمر بالقيادة مع زيادة السرعة", "استمر بالقيادة مع خفض السرعة", "انتظر في وسط التقاطع حتى يصبح واضحا", 3, Question.STATE_NEWYORK);
        addQuestion(nyQ24);
        Question nyQ25 = new Question("على العموم يجب ان تجاوز عربة في نفس اتجاهك ؟",
                "من اليسار", "من اليمين", "من أي اتجاه", 1, Question.STATE_NEWYORK);
        addQuestion(nyQ25);
        Question nyQ26 = new Question("خط أبيض متين على الحافة اليمنى في الطريق السريع في ميول نحو يسارك. وهذا يدل على أن",
                "الطريق ستصبح واسعة", "الطريق ستصبح ضيقة", "الطريق يحتوي علي تعرجات أمامك", 2, Question.STATE_NEWYORK);
        addQuestion(nyQ26);
        Question nyQ27 = new Question("قبل أن تغادر أماكن تركين السيارات الموازية لرصيف يجب عليك",
                "التأكد من الفرامل", "التأكد من سلامة محتويات السيارة", "شاهد حركة المرور بإدارة رأسك الى الخلف", 3, Question.STATE_NEWYORK);
        addQuestion(nyQ27);
        Question nyQ28 = new Question("لتغير الاتجاه يمينا يجب ؟",
                "الذهاب اولا الى الخط الايمن", "الذهاب اولا الى الخط الايسر", "خفض السرعة", 1, Question.STATE_NEWYORK);
        addQuestion(nyQ28);
        Question nyQ29 = new Question("يرتبط تركيز الكحول في الدم بـ ؟",
                "وقت الشرب", "كيفية الشرب ، وزنك ، والكمية", "نوع الكحول", 2, Question.STATE_NEWYORK);
        addQuestion(nyQ29);
        Question nyQ30 = new Question("أفضل وسيلة للحد من فرص وجود حادث متعلق بالكحول هو :",
                "لا تشرب قبل القيادة بـ 4 ساعات", "لا تشرب في المناسبات", "لا تشرب عند القيادة", 3, Question.STATE_NEWYORK);
        addQuestion(nyQ30);
        Question nyQ31 = new Question("الأدوية التي قد تؤثر على مهارات القيادة الأساسية هي :",
                "ادوية نزلات البرد والمهدئات ، وبعض العقاقير الطبية", "ادوية الإلتهابات", "ادوية الصداع", 1, Question.STATE_NEWYORK);
        addQuestion(nyQ31);
        Question nyQ32 = new Question("عندما تكون نسبة الكحول في الدم تصل الى 0.15 ٪ ،فان فرص ارتكاب حادث خطير هي؟",
                "30 مرة", " 25 مرة", "20 مرة", 2, Question.STATE_NEWYORK);
        addQuestion(nyQ32);
        Question nyQ33 = new Question("ما هو “المجرم المعتاد”؟",
                "أي الشخص  تم سحب رخصته 4 مرات خلال 3 سنوات", "أي الشخص  تم سحب رخصته 5 مرات خلال 3 سنوات", "أي الشخص  تم سحب رخصته 3 مرات خلال 3 سنوات", 3, Question.STATE_NEWYORK);
        addQuestion(nyQ33);
        Question nyQ34 = new Question("ما هو تقاطع غير المنضبط؟",
                "تقاطع حيث ليست هناك إشارات أو علامات المرور", "تقاطع لسيارات الإسعاف", "تقاطع للطوارئ", 1, Question.STATE_NEWYORK);
        addQuestion(nyQ34);
        Question nyQ35 = new Question("متى يجب عليك تشغيل الاضواء الخافضة؟",
                "اثناء القيادة في الليل", "القيادة في المدينة وعند ملاحقة او مقابلة سيارة أخرى ضمن 500 قدم", "اثناء القيادة علي طريق سريع واسع", 2, Question.STATE_NEWYORK);
        addQuestion(nyQ35);
    }

    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        cv.put(QuestionsTable.COLUMN_DIFFICULTY, question.getDifficulty());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    public ArrayList<Question> getAllQuestions() {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);
        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                question.setDifficulty(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_DIFFICULTY)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }

    public ArrayList<Question> getQuestions(String difficulty) {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        String[] selectionArgs = new String[]{difficulty};
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME +
                " WHERE " + QuestionsTable.COLUMN_DIFFICULTY + " = ?", selectionArgs);
        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                question.setDifficulty(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_DIFFICULTY)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }
}
