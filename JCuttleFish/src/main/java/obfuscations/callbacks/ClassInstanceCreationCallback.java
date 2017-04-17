package obfuscations.callbacks;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;


public class ClassInstanceCreationCallback extends AstNodeFoundCallback
{

    @Override
    public <V extends ASTNode> void notify ( V v )
    {
        if ( v instanceof ClassInstanceCreation )
        {
            super.addToCollection( v );
        }
    }
}
