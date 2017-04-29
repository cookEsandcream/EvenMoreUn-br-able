package providers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.enums.ObfuscatedNamesVariations;

import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ObfuscatedNamesProvider
{

    private final Logger logger = LoggerFactory.getLogger( ObfuscatedNamesProvider.class );

    public ObfuscatedNamesProvider ()
    {
    }

    public Deque<String> getObfuscatedNames ( ObfuscatedNamesVariations variation )
    {
        Stream<String> variableNamesStream = Stream.empty();

        String[] alphabet = {"kj23g6g2dh7h6gjh5k62ghf688", "dg5f36j5hd6dg7554jkg346dg7f", "dg5f36jShd6dg7554jkg346dg7f",
                "k2g256g73kj526fg7df7h4jjkj24", "kjhg5fd67456k63g567f465hkl5k", "k2g256g73kj526fg7df7h4jjkj24",
                "dg5f36j5hd6dg75S4jkg346dg7f", "gadsfhsgkjhjdkhgfedshdfk", "f465hkl5k31k2g256g73kj526f",
                "g5f36j5hd6dg7554jkg346dg7f3", "k2g256g73kj526fg7df7hAintj24", "Ikhdsgfajdkfkag1fkjahasdg",
                "dg7554jkg346dg7f3dg5f36j5hd6dg7554j", "gadsfhsgkjhjdkbgfedshdfk", "jhg5fd67456k63g567f465hkl5ksh",
                "dg5f36j5hd6dg75SAjkg3A6dg7f" };
        //Collections.shuffle(Arrays.asList(alphabet));

        String[] method_parameters = {"onXMLCreate", "gadsfhsgkjhjdkhgfadshdfk", "getStringAs", "lkhdsgfajdkfkaglfkjahasdg",
                "g5f36j5hdbdg7554jkg346dg7f3dg5f36j5hd6dg7554jkg346dg7fgadsfhsgkjhjdkhgfedshdfk", "StartActivity",
                "dg5fE6j5hd6dg7554jkg346dg7f", "j76767gffkdfhdflkghfffrhdhkjhkjZhgf3e4", "string5Z6fg7df7hAjjkj24",
                "g5f36j5hd6dg7554jkg34Gdg7f3dg5f36j5hd6dg7554jkjhg5fd67456k63g567f465hkl5kshdfk", "kjhlk0rrfd67456k63g567f465hkl5k",
                "j76767gffkdfhdflkkjhfffrhdhkjhkjZhgf3e4", "j76767yifkdfhdflkghfffrhdhkjhkjZhgf3e4", "Bundle_savedInstanceState",
                "g5f36j5hdbdg7554jkgE46dg7fEdg5f36j5hd6dg7554jkg346dg7fgadsfhsgkjhjdkhgfadshdfk", "$$54jkg3A6dg7fgad$sfhsgkjhidkhgfedshdfk$",
                "___________________________________________________", "klh4g56hdjkhghddddffggj45j6jk76h7ffjh5gf8fg78gh7kkkjgf6fdhjlhkhgf6fgh",
                "klh4gS6hdjkhghddddffggj4Sj6jk76h7ffjhSgf8fg78gh7kkkjgf6fdhjlhkhgf6fgh", "kj4jhgffdd8ds9sdghj3kj4kj4hj5hgjk4kj54h6hjf7f8gd9d9",
                "ifekjje9u8ji4uiyucghc56y4uco4ou894ujcu8jucijkuevuiouciwckhrik", "ifekjje9u8ji4uiyucghc56y4uco4ou894ujcu8jucjjkuevuiouciwckhrik",
                "kjkjlvdjrintkjjfvilzfmvijjifoiurdnintlkljdfkjlfhg", "Integer98376566374987389892",
                "wse894jes89eozjwo9flelfu8iegv18iesyhwo1opwqpyoqf", "jkiuoulefo8ef8sfj0w9opqlwnfvlksckms8s4rhonvv0y9owihdnch948un9w3ocn"};
        Collections.shuffle(Arrays.asList(method_parameters));

        String[] method_local_vars = {"k2g256g73kj526fg7df7hAjjkj24", "onCreateFile", "publicvoidobfuscate", "Override", "size",
                "g5f36j5hd6dg7554jkg346dg7f3dg5f36j5hd6dg7554jkg346dg7fgadsfhsgkjhjdkhgfedshdfk", "$$$$$$$$$$$$$$$$$$$$", "_",
                "g5f36j5hd6dg7554jkg346dg7f3dg5f36j5hd6dg7554jkjhg5fd67456k63g567f465hkl5kshdfk", "ImageViewText",
                "Rlayout", "lk2g256g73kj526fg7df7hAjjkj24", "j76767gffkdfhdflkghffrhdhkjhkjZhgf3e4", "$$54jkg346dg7fgad$sfhsgkjhjdkhgfedshdfk$",
                "int_", "k1h4g56hdjkhghddddffggj45j6jk76h7ffjh5gf8fg78gh7kkkjgf6fdhjlhkhgf6fgh",
                "_l_k_2_g_2_5_6_g_7_3_k_j_5_2_6_f_g_7_d_f_7_h_A_j_j_k_j_2_4_", "kj4jhgsfdd8ds9sdgsj3kj4kj4hjhkgjk4kj54h6hjf7f8gd9d9",
                "lkioejrdfnkyrsguvesklj$esk8948u4js_ljerj$fl", "iujklrekjnfdndiueui4484iuekuv7feheuesjseilu", "kjfvjijoirfvstringkljfvdjvjlzeu",
                "idrjkeru8987ejeef84eer8kierf4eiru8serf8urehf$o8reigjlorfv", "wse894jes89eozjwo9flelfu8iegvI8iesyhwolopwqpyoqf",
                "kdfjdfo89i34kjjncnvfnjviujv8948vnyv909um38uv48v7389oiwooiledkhvdn", "jkdjskfjrwl3kj56gjfk45l4kg66dh4",
                "kl5jk6hgf67dd9d09f6gh7hj4hj434jlk3k5gjgf67d"};
        Collections.shuffle(Arrays.asList(method_local_vars));

        String[] subclass_methods = {"j76767gffkdfhdflkghffrhdhkjhkjZhgf3e4", "OverrideprotectedvoidonCreate",
                "$$54jkg346dg7fgad$sfhsgkjhjdkhgfedshdfk$", "g5f36j5hd6dg7554jkg346dg7f3dg5f36j5hd6dg7554jkg346dg7fgadsfhsgkjhjdkhgfedshdfk",
                "k2g256g73kj526fg7df7hAjjkj24", "lk2g256g73kj526fg7df7hAjjkj24", "j76767gffkdfhdflkghffrhdhkjhkj2hgf3e4",
                "_", "super_onCreateOptionsMenu", "klh4g56hdjkhghdddddffggj45j6jk76h7ffjh5gf8fg78gh7kkkjgf6fdhjlhkhgf6fgh",
                "k1h4g56hdjkhghddddffggj45j6jk76h7ffjh5gf8fg78gh7kkkjgf6fdhjlhkhgf6fgh", "findViewWithId",
                "___________________________________________________", "kj4jhgffdd8ds9sdghj3kj4kj4hj5hgjk4kj54h6hjf7f8gd9d9",
                "iujklrekjnfdndiueui4484iuekuv7feheuesjseilu", "wse894jes89eozjwo9flelfu8iegv18iesyhwo1opwqpyoqf",
                "jkiuoulefo8ef8sfj0w9opqlwnfvlksckms8s4rhonvv0y9owihdnch948un9w3ocn", "klj5k6hjhg2ff45gfg6hjj8k9hjghfdfid"};
        Collections.shuffle(Arrays.asList(subclass_methods));

        String[] interface_methods = {"j76767gffkdfhdf1kghffrhdhkjhkj2hgf3e4", "ImageViewText", "$$$$$$$$$$$$$$$$$$$$", "__________",
                "g5f36j5hd6dg7554jkg346dg7f3dg5f36j5hd6dg7554jkjhg5fd67456k63g567f465hkl5kshdfk", "string$hashValue$generator",
                "__________________________________________________", "klh4g56hdjkhghddddffggj45j6jk76h7ffjh5gfBfg78gh7kkkjgf6fdhjlhkhgf6fgh",
                "_l_k_2_g_2_5_6_g_7_3_k_j_5_2_6_f_g_7_d_f_7_h_A_j_j_k_j_2_4_", "kj4jhgffdd8ds9sdghj3kj4kj4hj5hgjk4kj54h6djf7f8gd9d9",
                "lkioejrdfnkyrsguvesklj$esk8948u4js_ljerj$fl", "wse894jes89eozjwo9flelfuBiegvl8iesyhwolopwqpyoqf",
                "k15jk6hgf67dd9d09f6gh7hj4hj434jlk3k5gjgf67d", "lk4lkl2ll34kjk6h7gh7fh7f8gkkjklklg4g", "lkkljehh4j5gffg2kjhg0fgf0",
                "kl4lkj5ljkh6g7f7g6d8d9s97lkkljhku5gf", "kjdsfjklfnjiuvnkoo4eije8dkjvu8o", "jklvueo84ioe4o9efklliueflegleiful4wi9"};
        Collections.shuffle(Arrays.asList(interface_methods));

        String[] string_vars = {"string526fg7df7hAjjkj24", "MySecretSecrets", "g5f36j5hd6dg7554jkg346dg7fd", "setStateActive", "$",
                "g5f36j5hdbdg7554jkg346dg7f3dg5f36j5hd6dg7554jkg346dg7fgdsfhsgkjhjdkhgfedshdfk", "setImageURI", "android", "returnIntent",
                "lkhdsgfajdkfkaglfkjahasdglkhdsgfajdkfkaglfkjahasdg", "klh4gS6hdjkhghddddffggj45j6jk76h7ffjh5gf8fg78gh7kkkjgf6fdhjlhkhgf6fgh",
                "g5f36j5hd6dg7554jkg346dg7f3dg5f36j5hd6dg75$4jkg346dg7fgadsfhsgkjhjdkhgfedshdfk",
                "kj4jhgffdd8ds9sdghj3ks4kv4hj5hgjk4kj54h6hju7f8gd9d9", "ifekjje9u8ji4uiyucghc56y4ucc4ou894ujcu8jucjjkuevuiouciwckhrik",
                "stringPlaceholderMessage", "wse894jes89eoxjwo9flelfu8iegvI8iesyhwolopwqpyoqf", "wse89Ajes89eozjwo9flelfu8iegvI8iesyhwolopwqpyoqf",
                "kl5jk6hgf67dd9d09f6gh7hj4hj434j1k3k5gjgf67d", "$$$$$$$$$$$$$$$$$$$$$",
                "g5f36j5hdbdg7554jkg346dg7f3dg5f36j5hd6dg7554jkj346dg7fgdsfhsgkjhjdkhgfedshdfk", "setDate",
                "Osdsfd90doidf9d89d9feo9dfodofdf91lk1li3iug4d", "Osdsfd9Odoidf9d89d9feo9dfodofdf91lk1li3iug4d"};
        //Collections.shuffle(Arrays.asList(string_vars));

        if ( variation == ObfuscatedNamesVariations.ALPHABET )
        {
            variableNamesStream = Stream.of( alphabet );

        } else if ( variation == ObfuscatedNamesVariations.METHOD_PARAMETERS )
        {
            variableNamesStream = Stream.of( method_parameters );
        } else if ( variation == ObfuscatedNamesVariations.METHOD_LOCAL_VARS )
        {
            variableNamesStream = Stream.of( method_local_vars );
        } else if ( variation == ObfuscatedNamesVariations.SUBCLASS_METHODS )
        {
            variableNamesStream = Stream.of( subclass_methods );
        } else if ( variation == ObfuscatedNamesVariations.INTERFACE_METHODS )
        {
            variableNamesStream = Stream.of( interface_methods );
        } else if ( variation == ObfuscatedNamesVariations.STRING_VARS )
        {
            variableNamesStream = Stream.of( string_vars );
        } else
        {
            throw new RuntimeException( "Variation not supported " );
        }

        return variableNamesStream
                .distinct()
                .collect( Collectors.toCollection( LinkedList::new ) );
    }
}
