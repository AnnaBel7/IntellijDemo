import com.intellij.lang.java.JavaParserDefinition;
import com.intellij.lang.java.parser.FileParser;
import com.intellij.lang.java.parser.JavaParser;
import com.intellij.pom.java.LanguageLevel;
import com.intellij.psi.JavaTokenType;
import com.intellij.psi.impl.source.tree.ElementType;
import com.intellij.psi.tree.TokenSet;
import org.junit.Test;

/**
 * Created by roei on 12/9/16.
 */
public class PsiAstMatchingTest {
    private static final TokenSet IMPORT_LIST_STOPPER_SET = TokenSet.orSet(
            ElementType.MODIFIER_BIT_SET,
            TokenSet.create(JavaTokenType.CLASS_KEYWORD, JavaTokenType.INTERFACE_KEYWORD, JavaTokenType.ENUM_KEYWORD, JavaTokenType.AT));

    @Test
    public void a() {
        CharSequence src = "import s;";


        FileParser fileParser = JavaParser.INSTANCE.getFileParser();
        JavaParserDefinition parserDefinition = new JavaParserDefinition();

        PsiBuilderImpl psiBuilder = new PsiBuilderImpl(null, null, parserDefinition.getWhitespaceTokens(),
                parserDefinition.getCommentTokens(), parserDefinition.createLexer(LanguageLevel.JDK_1_8),
                null, src, null, null);

        System.out.println(psiBuilder.getTokenText());
        System.out.println(psiBuilder.getCurrentOffset());
        fileParser.parse(psiBuilder);
        System.out.println(psiBuilder.getCurrentOffset());
        System.out.println(psiBuilder.getLatestDoneMarker().getEndOffset());

        System.out.println(psiBuilder.getTreeBuilt());

    }
}
