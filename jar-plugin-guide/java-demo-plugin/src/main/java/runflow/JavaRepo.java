package runflow;

import org.jetbrains.annotations.NotNull;
import top.myrest.myflow.db.BaseRepo;
import top.myrest.myflow.enumeration.DataModifyMethod;

public class JavaRepo extends BaseRepo<Integer, JavaDoc> {

    public JavaRepo() {
        super(JavaDoc.class, true);
    }

    @Override
    public void onSyncFrom(@NotNull DataModifyMethod method, @NotNull JavaDoc doc) {
        super.onSyncFrom(method, doc);
    }
}
