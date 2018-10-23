[1mdiff --git a/demo03/src/main/resources/sqlmap/GraduationThemeMapper.xml b/demo03/src/main/resources/sqlmap/GraduationThemeMapper.xml[m
[1mindex d0b1ac8..8f41fb2 100644[m
[1m--- a/demo03/src/main/resources/sqlmap/GraduationThemeMapper.xml[m
[1m+++ b/demo03/src/main/resources/sqlmap/GraduationThemeMapper.xml[m
[36m@@ -11,56 +11,17 @@[m
         theme_seq, theme_title, theme_introduction, theme_teacher[m
     </sql>[m
 [m
[31m-    <select id="selectByPrimaryKey" resultMap="BaseResultMap" parameterType="java.lang.Integer">[m
[32m+[m[32m    <select id="queryByTitle" resultMap="BaseResultMap" parameterType="com.hallth.domain.GraduationTheme">[m
         select[m
         <include refid="Base_Column_List"/>[m
         from graduation_theme[m
[31m-        where theme_seq = #{themeSeq,jdbcType=INTEGER}[m
[32m+[m[32m        where theme_title = #{themeTitle, jdbcType=VARCHAR}[m
     </select>[m
 [m
[31m-    <insert id="insert" parameterType="com.hallth.domain.GraduationTheme">[m
[31m-        insert into graduation_theme (theme_seq, theme_title, theme_introduction, theme_teacher)[m
[31m-        values (#{themeSeq,jdbcType=INTEGER}, #{themeTitle,jdbcType=VARCHAR}, #{themeIntroduction,jdbcType=VARCHAR},[m
[31m-          #{themeTeacher,jdbcType=VARCHAR}[m
[31m-    </insert>[m
[31m-[m
[31m-    <insert id="insertSelective" parameterType="com.hallth.domain.GraduationTheme">[m
[31m-        insert into graduation_theme[m
[31m-        <trim prefix="(" suffix=")" suffixOverrides=",">[m
[31m-            <if test="themeSeq != null">[m
[31m-                theme_seq,[m
[31m-            </if>[m
[31m-            <if test="themeTitle != null">[m
[31m-                theme_title,[m
[31m-            </if>[m
[31m-            <if test="themeIntroduction != null">[m
[31m-                theme_introduction,[m
[31m-            </if>[m
[31m-            <if test="themeTeacher != null">[m
[31m-                theme_teacher,[m
[31m-            </if>[m
[31m-        </trim>[m
[31m-        <trim prefix="values (" suffix=")" suffixOverrides=",">[m
[31m-            <if test="themeSeq != null">[m
[31m-                #{themeSeq,jdbcType=INTEGER},[m
[31m-            </if>[m
[31m-            <if test="themeTitle != null">[m
[31m-                #{themeTitle,jdbcType=VARCHAR},[m
[31m-            </if>[m
[31m-            <if test="themeIntroduction != null">[m
[31m-                #{themeIntroduction,jdbcType=VARCHAR},[m
[31m-            </if>[m
[31m-            <if test="themeTeacher != null">[m
[31m-                #{themeTeacher,jdbcType=VARCHAR},[m
[31m-            </if>[m
[31m-        </trim>[m
[31m-      </insert>[m
[31m-[m
[31m-    <update id="updateByPrimaryKeySelective" parameterType="com.hallth.domain.GraduationTheme">[m
[31m-[m
[31m-    </update>[m
[31m-[m
[31m-    <update id="updateByPrimaryKey" parameterType="com.hallth.domain.GraduationTheme">[m
[31m-[m
[31m-  </update>[m
[32m+[m[32m    <select id="queryBySeq" resultMap="BaseResultMap" parameterType="com.hallth.domain.GraduationTheme">[m
[32m+[m[32m        select[m
[32m+[m[32m        <include refid="Base_Column_List"/>[m
[32m+[m[32m        from graduation_theme[m
[32m+[m[32m        where theme_seq = #{themeSeq, jdbcType=INTGER}[m
[32m+[m[32m    </select>[m
 </mapper>[m
\ No newline at end of file[m
